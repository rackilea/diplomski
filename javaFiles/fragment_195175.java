import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagingTest2 {
    public static void main(String[] args) throws IOException {
        BufferedImage src = ImageIO.read(new File("in.png")); // 71 kb

        // here goes custom palette
        IndexColorModel cm = new IndexColorModel(
                3, // 3 bits can store up to 8 colors
                6, // here I use only 6
                //          RED  GREEN1 GREEN2  BLUE  WHITE BLACK              
                new byte[]{-100,     0,     0,    0,    -1,     0},
                new byte[]{   0,  -100,    60,    0,    -1,     0},
                new byte[]{   0,     0,     0, -100,    -1,     0});

        // draw source image on new one, with custom palette
        BufferedImage img = new BufferedImage(
                src.getWidth(), src.getHeight(), // match source
                BufferedImage.TYPE_BYTE_INDEXED, // required to work
                cm); // custom color model (i.e. palette)
        Graphics2D g2 = img.createGraphics();
        g2.drawImage(src, 0, 0, null);
        g2.dispose();

        // output
        ImageIO.write(img, "png", new File("out.png"));   // 2,5 kb
    } 
}