import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImagingTest {

    public static void main(String[] args) throws IOException {
        String url = "http://icomix.eu/gr/images/non-batman-t-shirt-gross.jpg";
        String text = "Hello Java Imaging!";
        byte[] b = mergeImageAndText(url, text, new Point(200, 200));
        FileOutputStream fos = new FileOutputStream("so2.png");
        fos.write(b);
        fos.close();
    }

    public static byte[] mergeImageAndText(String imageFilePath,
            String text, Point textPosition) throws IOException {
        BufferedImage im = ImageIO.read(new URL(imageFilePath));
        Graphics2D g2 = im.createGraphics();
        g2.drawString(text, textPosition.x, textPosition.y);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(im, "png", baos);
        return baos.toByteArray();
    }
}