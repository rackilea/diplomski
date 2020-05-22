package iTextTester;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class tester {

    public static final String RESULT = "C:/Users/me/Downloads/text.pdf";
public static void main(String[] args) throws DocumentException,
        IOException {
    new tester().createPdf(RESULT);
}

public void createPdf(String filename) throws DocumentException,
        IOException {
    Document document = new Document(PageSize.LETTER);
    PdfWriter.getInstance(document, new FileOutputStream(filename));
    document.open();
    document.add(new Paragraph("Hello World!"));
    document.close();
}