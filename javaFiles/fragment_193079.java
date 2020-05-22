import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ReadImages {

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new URL("https://t.williamgates.net/image-E026_55A0B5BB.jpg").openStream());
            ImageIO.write(img, "jpg", new File("image.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ReadImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}