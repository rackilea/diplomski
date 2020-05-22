import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class DottedIExampleWithGraphics2D {

    private static final File aFontFile = new File(("c:/windows/fonts/arialuni.ttf"));
    private static final float WIDTH = 90;
    private static final float HEIGHT = 50;
    private DefaultFontMapper mapper = new DefaultFontMapper() {
        @Override
        public BaseFont awtToPdf(Font font) {
            try {
                return BaseFont.createFont(aFontFile.getAbsolutePath(),
                        BaseFont.IDENTITY_H,
                        BaseFont.NOT_EMBEDDED);
            } catch (DocumentException e) {
                e.printStackTrace();  //blah
            } catch (IOException e) {
                e.printStackTrace();  //blah
            }
            return null;
        }

        @Override
        public Font pdfToAwt(BaseFont baseFont, int i) {
            try {
                return Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(aFontFile));
            } catch (FontFormatException e) {
                e.printStackTrace();  //blah
            } catch (IOException e) {
                e.printStackTrace();  //blah
            }
            return null;
        }
    };


    public void testWriteOfStringWithFont() throws IOException, DocumentException {


        Font theFont = mapper.pdfToAwt(null, 18);
        Document document = new Document(new Rectangle(WIDTH, HEIGHT));

        File testFile = new File("learning_withfont.pdf");
        FileOutputStream fos = new FileOutputStream(testFile);
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        PdfTemplate tp = cb.createTemplate(WIDTH, HEIGHT);
        cb.addTemplate(tp, 0, 0);
        Graphics2D graphics = tp.createGraphics(WIDTH, HEIGHT, mapper);

        graphics.setColor(Color.blue);
        graphics.setFont(theFont);
        graphics.drawString(" \u0130 , \u0131 , \u0049, \u0069", 10, 10);

        graphics.drawString("some", 10, 30);

        //
        graphics.dispose();
        document.close();

        System.out.println("testFile.getAbsolutePath() = " + testFile.getAbsolutePath());
    }

    /**
     */
    public static void main(String[] args) throws IOException, DocumentException {
        new DottedIExampleWithGraphics2D().testWriteOfStringWithFont();
    }
}