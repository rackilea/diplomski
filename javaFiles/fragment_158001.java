import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScalingMethodComparison
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
        f.getContentPane().setLayout(new GridLayout(0,1));

        Dimension larger = new Dimension(190,190);
        Dimension smaller = new Dimension(60,60);

        f.getContentPane().add(createPanel(larger, false));
        f.getContentPane().add(createPanel(larger, true));
        f.getContentPane().add(createPanel(smaller, false));
        f.getContentPane().add(createPanel(smaller, true));

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static JPanel createPanel(Dimension d, boolean highQuality)
    {
        JPanel p = new JPanel(new GridLayout(1,3));
        for (ScalingMethodComparisonPanel.ScalingMethod scalingMethod : 
            ScalingMethodComparisonPanel.ScalingMethod.values())
        {
            p.add(createPanel(d, scalingMethod, highQuality));
        }
        return p;
    }

    private static JPanel createPanel(
        Dimension d, ScalingMethodComparisonPanel.ScalingMethod scalingMethod, 
        boolean highQuality)
    {
        JPanel p = new JPanel(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder(
            scalingMethod.toString()+(highQuality?" (HQ)":"")));
        JPanel scalingMethodComparisonPanel = 
            new ScalingMethodComparisonPanel(
                createObjects(), d, scalingMethod, highQuality);
        p.add(scalingMethodComparisonPanel);
        return p;
    }

    // Returns a list of objects that should be drawn, 
    // occupying a rectangle of 100x100 in WORLD COORDINATES
    private static List<Shape> createObjects()
    {
        List<Shape> objects = new ArrayList<Shape>();
        objects.add(new Ellipse2D.Double(10,10,80,80));
        objects.add(new Rectangle2D.Double(20,20,60,60));
        objects.add(new Line2D.Double(30,30,70,70));
        return objects;
    }
}


class ScalingMethodComparisonPanel extends JPanel
{
    private static final Color COLORS[] = {
        Color.RED, Color.GREEN, Color.BLUE,
    };

    enum ScalingMethod
    {
        SCALING_IMAGE,
        SCALING_GRAPHICS,
        SCALING_SHAPES,
    }

    private final List<Shape> objects;
    private final ScalingMethod scalingMethod;
    private final boolean highQuality;

    private final Dimension originalSize = new Dimension(100,100);
    private final Dimension scaledSize;

    private BufferedImage image;

    public ScalingMethodComparisonPanel(
        List<Shape> objects,
        Dimension scaledSize,
        ScalingMethod scalingMethod,
        boolean highQuality)
    {
        this.objects = objects;
        this.scaledSize = new Dimension(scaledSize);
        this.scalingMethod = scalingMethod;
        this.highQuality = highQuality;
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(scaledSize);
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(), getHeight());

        if (highQuality)
        {
            g.setRenderingHint( 
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(
                RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY);
        }

        if (scalingMethod == ScalingMethod.SCALING_IMAGE)
        {
            paintByScalingImage(g);
        }
        else if (scalingMethod == ScalingMethod.SCALING_GRAPHICS)
        {
            paintByScalingGraphics(g);
        }
        else if (scalingMethod == ScalingMethod.SCALING_SHAPES)
        {
            paintByScalingShapes(g);
        }
    }

    private void paintByScalingImage(Graphics2D g)
    {
        if (image == null)
        {
            image = new BufferedImage(
                originalSize.width, originalSize.height,
                BufferedImage.TYPE_INT_ARGB);
        }
        Graphics2D ig = image.createGraphics();
        paintObjects(ig, null);
        ig.dispose();

        g.drawImage(image, 0, 0, scaledSize.width, scaledSize.height, null);
    }

    private void paintByScalingGraphics(Graphics2D g)
    {
        AffineTransform oldAT = g.getTransform();
        double scaleX = (double)scaledSize.width / originalSize.width;
        double scaleY = (double)scaledSize.height / originalSize.height;
        g.scale(scaleX, scaleY);
        paintObjects(g, null);
        g.setTransform(oldAT);
    }

    private void paintByScalingShapes(Graphics2D g)
    {
        double scaleX = (double)scaledSize.width / originalSize.width;
        double scaleY = (double)scaledSize.height / originalSize.height;
        AffineTransform at = 
            AffineTransform.getScaleInstance(scaleX, scaleY);
        paintObjects(g, at);
    }



    private void paintObjects(Graphics2D g, AffineTransform at)
    {
        for (int i=0; i<objects.size(); i++)
        {
            Shape shape = objects.get(i);
            g.setColor(COLORS[i%COLORS.length]);
            if (at == null)
            {
                g.draw(shape);
            }
            else
            {
                g.draw(at.createTransformedShape(shape));
            }
        }
    }
}