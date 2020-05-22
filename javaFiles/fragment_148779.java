import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFUtil {

    public static void saveFirstPageThumbnail() throws IOException {
        PDDocument document = PDDocument.load("C:\\testbook.pdf");
        List<PDPage> pages = document.getDocumentCatalog().getAllPages();
        PDPage page = pages.get(0); //first one
        BufferedImage bufferedImage = page.convertToImage();
        File outputFile = new File( "C:\\image.jpg");
        ImageIO.write(bufferedImage, "jpg", outputFile);
    }

}