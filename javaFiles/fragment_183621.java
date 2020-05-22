import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SierpinskiCarpet extends Applet
{
    private int d0 = 729; // 3^6
    private BufferedImage bufferedImage;
    private final GraphicsConfiguration gConfig = GraphicsEnvironment
        .getLocalGraphicsEnvironment().getDefaultScreenDevice()
        .getDefaultConfiguration();

    public void init()
    {
        resize(d0, d0);
    }

    public void paint(Graphics g)
    {
        drawSierpinskiCarpet(g, 0, 0, getWidth(), getHeight());
        storeImage();
    }

    public void storeImage()
    {
        BufferedImage image = create(d0, d0, true);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        drawSierpinskiCarpet(g, 0, 0, getWidth(), getHeight());
        g.dispose();
        try
        {
            ImageIO.write(image, "png", new File(
                "C:\\Users\\User\\Desktop\\sierpinskiImage.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void drawSierpinskiCarpet(Graphics g, int xOL, int yOL,
        int breedte, int hoogte)
    {
        if (breedte > 2 && hoogte > 2)
        {
            int b = breedte / 3;
            int h = hoogte / 3;
            g.fillRect(xOL + b, yOL + h, b, h);
            for (int k = 0; k < 9; k++)
                if (k != 4)
                {
                    int i = k / 3;
                    int j = k % 3;
                    drawSierpinskiCarpet(g, xOL + i * b, yOL + j * h, b, h);
                }
        }
    }

    private BufferedImage create(final int width, final int height,
        final boolean alpha)
    {
        BufferedImage buffer =
            gConfig.createCompatibleImage(width, height, alpha
                ? Transparency.TRANSLUCENT : Transparency.OPAQUE);
        return buffer;
    }
}