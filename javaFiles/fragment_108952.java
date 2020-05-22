import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class DocumentService {

    public byte[] convertPDFtoImage(byte[] bytesPDF) {
        InputStream targetStream = new ByteArrayInputStream(bytesPDF);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PDDocument document = null;
        try {
            document = PDDocument.load(targetStream);
            PDFRenderer renderer = new PDFRenderer(document);
            int pageNumber = 1;
            BufferedImage bi = renderer.renderImageWithDPI(pageNumber, 300);
            ImageIO.write(bi, "jpg", baos);
            baos.flush();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (document != null) {
                try {
                    document.close();
                    baos.close();
                    log.info("End convert PDF to Images process");
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return baos.toByteArray();
    }
}