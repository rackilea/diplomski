import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;

public class FontTest {

    /** The resulting PDF file. */
    public static final String RESULT = "fontTest.pdf";
    /** the text to render. */
    public static final String TEST = "Test to render this text with the turkish lira character \u20BA";

    public void createPdf(String filename) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        BaseFont bf = BaseFont.createFont(
            "pathToMyFont/myFont.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(bf, 20);
        ColumnText column = new ColumnText(writer.getDirectContent());
        column.setSimpleColumn(36, 730, 569, 36);
        column.addElement(new Paragraph(TEST, font));
        column.go();
        document.close();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        new FontTest().createPdf(RESULT);
    }
}