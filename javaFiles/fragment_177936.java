import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

public class GifBounds {

    /** @see https://stackoverflow.com/questions/5688104 */
    public static void main(String[] args) throws IOException {
        search(new URL("http://i55.tinypic.com/263veb9.gif"));
    }
    public static void search(URL url) throws IOException {
        try {
            ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
            reader.setInput(ImageIO.createImageInputStream(url.openStream()));
            int i = reader.getMinIndex();
            while (true) {
                BufferedImage bi = reader.read(i++);
                System.out.println(i
                    + ": " + bi.getWidth()
                    + ", " + bi.getHeight());
            }

        } catch (IndexOutOfBoundsException e) {
            // ignored
        }
    }
}