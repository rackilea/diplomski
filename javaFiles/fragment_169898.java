import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageRotation {

    public static void main(String[] args) {
        ImageRotation rotation = new ImageRotation();
        rotation.rotate("input.png", 45, "output.png");
    }

    public void rotate(String inputImageFilename, double angle, String outputImageFilename) {

        try {
            BufferedImage inputImage = ImageIO.read(new File(inputImageFilename));
            BufferedImage outputImage = rotateImage(inputImage, angle);
            ImageIO.write(outputImage, "PNG", new File(outputImageFilename));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedImage rotateImage(BufferedImage sourceImage, double angle) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = destImage.createGraphics();

        AffineTransform transform = new AffineTransform();
        transform.rotate(angle / 180 * Math.PI, width / 2 , height / 2);
        g2d.drawRenderedImage(sourceImage, transform);

        g2d.dispose();
        return destImage;
    }
}