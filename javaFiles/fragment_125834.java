import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class CustomFillingTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ColorFunction colorFunction = new ColorFunction();
        Area area = createTestArea();

        CustomFillingPanel customFillingPanel = 
            new CustomFillingPanel(colorFunction, area);
        f.getContentPane().add(customFillingPanel, BorderLayout.CENTER);

        f.setSize(400,200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static Area createTestArea()
    {
        Font font = new Font("Monospaced", Font.BOLD, 120);
        final FontRenderContext fontRenderContext = 
            new FontRenderContext(null, true, true);
        GlyphVector glyphVector = font.createGlyphVector(
            fontRenderContext, "Test");
        Shape shape = glyphVector.getOutline(0,0);
        AffineTransform at = AffineTransform.getTranslateInstance(40, 100);
        Area area = new Area(at.createTransformedShape(shape));
        return area;
    }




}



class ColorFunction
{
    private final BufferedImage bufferedImage;

    ColorFunction()
    {
        this.bufferedImage = createDummyImage(1000, 1000);
    }

    private static BufferedImage createDummyImage(int w, int h)
    {
        Random random = new Random(1);
        BufferedImage image = 
            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, w, h);
        for (int i=0; i<1000; i++)
        {
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            Color c = new Color(r,g,b);
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int n = random.nextInt(w/10);
            graphics.setColor(c);
            graphics.fillRect(x,y,n,n);
        }
        graphics.dispose();
        return image;
    }

    int getColor(int x, int y)
    {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        return bufferedImage.getRGB(x%w, y%h);
    }
}


class CustomFillingPanel extends JPanel
{
    private final ColorFunction colorFunction;
    private final Area area;

    CustomFillingPanel(ColorFunction colorFunction, Area area)
    {
        this.colorFunction = colorFunction;
        this.area = area;
    }

    private static void paintIntoImage(
        ColorFunction colorFunction, BufferedImage bufferedImage)
    {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        for (int y=0; y<h; y++)
        {
            for (int x=0; x<w; x++)
            {
                int rgb = colorFunction.getColor(x, y);
                bufferedImage.setRGB(x, y, rgb);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Rectangle b = area.getBounds();
        BufferedImage bufferedImage = 
            new BufferedImage(b.width,  b.height, BufferedImage.TYPE_INT_ARGB);
        paintIntoImage(colorFunction, bufferedImage);

        g.setClip(area);
        g.drawImage(bufferedImage, b.x, b.y, null);

    }
}