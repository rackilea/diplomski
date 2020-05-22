import java.io.*;

import junit.framework.TestCase;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

public class TestAnnotations extends TestCase
{
    // a phonetic approximation
    final static String LAWRENCE_OF_ARABIA = "\u0644\u0648\u0631\u0627\u0646\u0633\u0627\u0644\u0639\u0631\u0628";

    public void testUnicodeAnnotation() throws Exception
    {
        final PdfReader origPdfReader = new PdfReader("test.pdf");
        final OutputStream outputStream = new FileOutputStream("test-annot.pdf");
        final PdfStamper pdfStamper = new PdfStamper(origPdfReader, outputStream, '\0', true);

        Rectangle rect = new Rectangle(100, 100);
        PdfAnnotation annotation = PdfAnnotation.createText(pdfStamper.getWriter(), rect, LAWRENCE_OF_ARABIA, LAWRENCE_OF_ARABIA, true, "Help");
        pdfStamper.addAnnotation(annotation, 1);
        pdfStamper.close();
        outputStream.close();
    }
}