import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class ExtractItalicText {

    final static class ItalicTextExtractionStrategy extends SimpleTextExtractionStrategy {
        @Override
        public void renderText(TextRenderInfo arg0) {
            DocumentFont font = arg0.getFont();
            String[][] familyFontNamesArray = font.getFamilyFontName();
            for(String[] familyFontNames : familyFontNamesArray) {
                for(String familyFontName : familyFontNames) {
                    if(familyFontName.toLowerCase().contains("italic")) {
                        float italicAngle = font.getFontDescriptor(BaseFont.ITALICANGLE,
                                0 /* not relevant for ItalicAngle otherwise 1000 is a good value 
                                     source: http://grepcode.com/file/repo1.maven.org/maven2/com.itextpdf/itextpdf/5.4.2/com/itextpdf/text/pdf/DocumentFont.java#DocumentFont */);
                        if(italicAngle < 0) {
                            super.renderText(arg0);
                        }
                        break;
                    }
                }   
            }
        }
    }

    public static void extractItalicText(String pdf) throws IOException {
        PdfReader reader = null;
        PrintWriter out = null;
        PrintWriter outItalic = null;
        long s = System.currentTimeMillis();
        try {
            System.out.println("Processing: " + pdf + " ...");
            // output for original text including italic styled
            out = new PrintWriter(new FileOutputStream("src/main/resources/" + new File(pdf).getName() + ".txt"));
            // output for italic styled text only
            outItalic = new PrintWriter(new FileOutputStream("src/main/resources/" + new File(pdf).getName() + "_italic.txt"));
            reader = new PdfReader(pdf);
            int numberOfPages = reader.getNumberOfPages();
            for(int pageNumber = 1; pageNumber <= numberOfPages; pageNumber++) {
                // extract italic text
                String pageItalicText = PdfTextExtractor.getTextFromPage(reader, pageNumber, new ItalicTextExtractionStrategy());
                if(pageItalicText.trim().length() > 0) {
                    // we have some italic text in the current page, so we get the hole text of the page
                    // to search for the lines where the italic text is located
                    String textFromPage = PdfTextExtractor.getTextFromPage(reader, pageNumber);
                    String[] textLinesFromPage = textFromPage.split("[\r\n]");

                    // punctuation marks etc. are sometime not part of the italic text, so we need to clean the line
                    // map a cleaned line to a raw line
                    Map<String, String> cleanedtextLines = new LinkedHashMap<String, String>(textLinesFromPage.length * 4 / 3 + 1);
                    for(String line : textLinesFromPage) {
                        out.println(line);
                        // clean line from all non-word characters
                        cleanedtextLines.put(line.replaceAll("\\W", ""), line);
                    }
                    // split the italic text into lines
                    String[] italicTextLines = pageItalicText.split("[\r\n]");
                    Set<String> linesContainingItalicText = new HashSet<String>(italicTextLines.length * 4 / 3 + 1);
                    for(String italicText : italicTextLines) {
                        // clean the italic text from non-word characters
                        String cleanedItalicText = italicText.replaceAll("\\W", "");
                        // search for the corresponding line
                        for(Entry<String, String> lineEntry : cleanedtextLines.entrySet()) {                            
                            if((! linesContainingItalicText.contains(lineEntry.getKey())) 
                                    && lineEntry.getKey().contains(cleanedItalicText)) {
                                linesContainingItalicText.add(lineEntry.getKey());
                                // output the raw line
                                outItalic.println(lineEntry.getValue());
                            }
                        }
                    }
                }
                out.println("==== Page " + pageNumber + " =========================================================\n");
                outItalic.println("==== Page " + pageNumber + " =========================================================\n");
            }

        } finally {
            if(out != null) {
                out.close();
            }
            if(outItalic != null) {
                outItalic.close();
            }
            if(reader != null) {
                reader.close(); 
            }
            long e = System.currentTimeMillis();
            System.out.println("done (" + (e-s) + " ms)");
        }
    }

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        for(String arg: args) {
            extractItalicText(arg);
        }
    }
}