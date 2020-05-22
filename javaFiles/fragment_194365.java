import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.PDFRenderer

import javax.imageio.ImageIO
import java.awt.*
import java.awt.geom.AffineTransform
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import java.awt.image.RenderedImage

class RegionPDFRenderer {

    private static final int POINTS_IN_INCH = 72

    private final PDDocument document
    private final PDFRenderer renderer
    private final int resolutionDotPerInch

    RegionPDFRenderer(PDDocument document, int resolutionDotPerInch) {
        this.document = document
        this.renderer = new PDFRenderer(document)
        this.resolutionDotPerInch = resolutionDotPerInch
    }

    RenderedImage renderRect(int pageIndex, Rectangle2D rect) {
        BufferedImage image = createImage(rect)
        Graphics2D graphics = createGraphics(image, rect)
        renderer.renderPageToGraphics(pageIndex, graphics)
        graphics.dispose()
        image
    }

    private BufferedImage createImage(Rectangle2D rect) {
        double scale = resolutionDotPerInch / POINTS_IN_INCH
        int bitmapWidth  = rect.width  * scale
        int bitmapHeight = rect.height * scale
        new BufferedImage(bitmapWidth, bitmapHeight, BufferedImage.TYPE_INT_RGB)
    }

    private Graphics2D createGraphics(BufferedImage image, Rectangle2D rect) {
        double scale = resolutionDotPerInch / POINTS_IN_INCH
        AffineTransform transform = AffineTransform.getScaleInstance(scale, scale)
        transform.concatenate(AffineTransform.getTranslateInstance(-rect.x, -rect.y))

        Graphics2D graphics = image.createGraphics()
        graphics.setBackground(Color.WHITE)
        graphics.setTransform(transform)
        graphics
    }

    static void main(String[] args) {
        String filePath = './input.pdf'
        def pageIndex = 0
        def region = new Rectangle(70, 472, 498, 289)
        def resolutionForHiDPIScreenRendering = 220 /* dpi */

        PDDocument doc = PDDocument.load(new File(filePath))
        try {
            def renderer = new RegionPDFRenderer(doc, resolutionForHiDPIScreenRendering)
            def image = renderer.renderRect(pageIndex, region)
            ImageIO.write(image, "png", new File("./output/image.png"))
        } finally {
            doc.close()
        }
    }

}