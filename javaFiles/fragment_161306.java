import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.*;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.IOException;
import java.util.HashSet;
import java.net.*;
import java.io.*;
import java.io.FileInputStream;



public class X {
    public static boolean verifyPDFContent(String reqTextInPDF) throws IOException{

        PDDocument doc = PDDocument.load(new File("test.pdf"));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(doc);
        doc.close();
        System.out.println(text);
        return text.contains(reqTextInPDF);
    }

    public static void main( String [] args) throws IOException{
        System.out.println(verifyPDFContent("Charity"));
    }
}