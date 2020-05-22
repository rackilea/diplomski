import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageColors
{
    public static void main(String[] args) throws IOException
    {
        BufferedImage image = ImageIO.read(
            new URL("https://i.stack.imgur.com/pSUFR.png"));

        // This will show that the image has an IndexColorModel.
        // This does not necessarily support all colors.
        System.out.println(image);

        // Convert the image to a generic ARGB image
        image = convertToARGB(image);

        // Now, the image has a DirectColorModel, supporting all colors
        System.out.println(image);

        Graphics2D g = image.createGraphics();
        g.setColor(Color.PINK);
        g.fillRect(50, 50, 50, 50);
        g.dispose();

        ImageIO.write(image, "PNG", new File("RightColors.png"));
    }

    public static BufferedImage convertToARGB(BufferedImage image)
    {
        BufferedImage newImage = new BufferedImage(
            image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }    
}