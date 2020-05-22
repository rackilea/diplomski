import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.io.File;

public class MakeImage
{
    public static void main(String[] args)
    { 
        BufferedImage im = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_BINARY);
        im.setRGB(10, 10, Color.WHITE.getRGB());

        try
        {
            ImageIO.write(im, "png", new File("image.png"));
        }
        catch (IOException e)
        {
            System.out.println("Some exception occured " + e);
        }
    }
}