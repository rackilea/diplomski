import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import java.io.IOException;

public class Main {
    public static void main(String[] argv) throws COSVisitorException, InvalidPasswordException, CryptographyException, IOException {
        PDDocument document = PDDocument.load("input.pdf");

        if (document.isEncrypted()) {
            document.decrypt("");
        }

        PDDocumentCatalog catalog = document.getDocumentCatalog();
        for (Object pageObj :  catalog.getAllPages()) {
            PDPage page = (PDPage) pageObj;
            PDResources resources = page.findResources();
            resources.getImages().clear();
        }

        document.save("strippedOfImages.pdf");
    }
}