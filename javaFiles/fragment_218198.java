import java.io.FileOutputStream;

//com.lowagie...   old version
//com.itextpdf...  recent version
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import org.apache.commons.codec.binary.Base64;


public class Image64ToPDF {
    public static void main(String ... args) {
        Document document = new Document();
        //
        String b64Image = "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"; // .gif and .jpg are ok too!
        String output = "c:/output.pdf";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(output));
            document.open();
            byte[] decoded = Base64.decodeBase64(b64Image.getBytes());
            document.add(Image.getInstance(decoded));
            document.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}