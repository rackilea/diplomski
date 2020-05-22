import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScalingDrawnObjects
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
        ScalingDrawnObjectsPanel p = new ScalingDrawnObjectsPanel();
        f.getContentPane().add(p);
        f.setSize(600,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class ScalingDrawnObjectsPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        Shape rectangle = new Rectangle2D.Double(2, 2, 10, 13);

        g.setColor(Color.RED);
        drawWithScaledGraphics(g, rectangle);

        g.translate(100, 0);

        drawScaledObject(g, rectangle);
    }

    private static void drawWithScaledGraphics(Graphics2D g, Shape shape)
    {
        AffineTransform oldAt = g.getTransform();
        g.scale(5.0, 5.0);
        g.draw(shape);
        g.setTransform(oldAt);
    }

    private static void drawScaledObject(Graphics2D g, Shape shape)
    {
        AffineTransform at = AffineTransform.getScaleInstance(5.0, 5.0);
        g.draw(at.createTransformedShape(shape));
    }

}