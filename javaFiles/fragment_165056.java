package test;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;

public class Main {
    // TODO adapt 1st two constants
    private static final String FILE_OUTPUT_PATH = "yourPath/yourFile.pdf"; 
    private static final String FONT_PATH = "test/yourUnicodeFont.ttf";
    private static final String EXAMPLE = "\u060F";

    public static void main(String[] args) {

        // if the following line returns garbage characters,
        // make sure you set your project (and console output) to UTF-8
        System.out.println(EXAMPLE);
        PDDocument document = null;
        try {
            // generates custom document
            document = new PDDocument();
            // gets the Arial.ttf font you placed in your src/test folder
            InputStream fontStream = Main.class.getClassLoader()
                    .getResourceAsStream(FONT_PATH);
            // loads it in the doc
            PDFont font = PDTrueTypeFont.loadTTF(document, fontStream);

            // closes the stream
            fontStream.close();
            // initializing a new PDF page
            PDPage page = new PDPage();
            // initializing a page content stream
            PDPageContentStream stream = new PDPageContentStream(document,
                    page, true, false);
            // assigining font to page content stream
            stream.setFont(font, 24);
            // setting color
            stream.setNonStrokingColor(Color.BLACK);
            // starts drawing text
            stream.beginText();
            // draws something in Arabic    
            stream.drawString(EXAMPLE);
            // stops drawing text
            stream.endText();
            // closes stream
            stream.close();
            // imports the page into the doc
            document.importPage(page);
            // creating file
            File file = new File(FILE_OUTPUT_PATH);
            file.createNewFile();
            // creating output stream
            OutputStream outputStream = new FileOutputStream(file);
            // saving doc content to stream
            document.save(outputStream);
            // flushing stream
            outputStream.flush();
            // closing stream
            outputStream.close();
        }
        // oops! something wrong happened, see stack trace
        catch (Throwable t) {
            t.printStackTrace();
        }
        finally {
            // closing doc
            if (document != null) {
                try {
                    document.close();
                }
                // oops!
                catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }
}