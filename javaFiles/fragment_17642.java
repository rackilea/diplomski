import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.function.DoubleConsumer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RecursiveTreeDrawing
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
        f.getContentPane().setLayout(new BorderLayout());

        RecursiveTreeDrawingPanel p = new RecursiveTreeDrawingPanel();
        p.setPreferredSize(new Dimension(500,500));
        f.getContentPane().add(p, BorderLayout.CENTER);

        JPanel c = new JPanel(new GridLayout(0,1));

        c.add(createControl("left length", 0, 0.9, 
            d -> p.setLeftLengthFactor(d)));
        c.add(createControl("left width", 0, 0.9, 
            d -> p.setLeftWidthFactor(d)));
        c.add(createControl("left angle", 0, Math.PI, 
            d -> p.setLeftAngleDelta(d)));

        c.add(createControl("right length", 0, 0.9, 
            d -> p.setRightLengthFactor(d)));
        c.add(createControl("right width", 0, 0.9, 
            d -> p.setRightWidthFactor(d)));
        c.add(createControl("right angle", -Math.PI, 0, 
            d -> p.setRightAngleDelta(d)));
        f.getContentPane().add(c, BorderLayout.SOUTH);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static JPanel createControl(
        String name, double min, double max, DoubleConsumer doubleConsumer)
    {
        JPanel p = new JPanel(new GridLayout(1,0));
        p.add(new JLabel(name));
        JSlider slider = new JSlider(0, 100, 0);
        slider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                int value = slider.getValue();
                double v = value / 100.0;
                double d = min + v * (max - min);
                doubleConsumer.accept(d);
            }
        });
        p.add(slider);

        return p;
    }

}


class RecursiveTreeDrawingPanel extends JPanel
{
    private double leftLengthFactor = 3.0 / 4.0;
    private double leftWidthFactor = 3.0 / 4.0;
    private double leftAngleDelta = Math.PI / 5.0;
    private double rightLengthFactor = 2.0 / 3.0;
    private double rightWidthFactor = 1.0 / 2.0;
    private double rightAngleDelta = - Math.PI / 5.0; 

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
        Point2D start = new Point2D.Double(
            getWidth() * 0.5, 
            getHeight() * 0.7);
        g.setColor(Color.GRAY);
        drawTree(g, start, 100.0, 2.0, 10.0, 0);
    }

    private void drawTree(Graphics2D g, 
        Point2D start, double length, double minLength, 
        double width, double alpha)
    {
        if (length < minLength)
        {
            return;
        }
        g.setStroke(new BasicStroke((float)width, 
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Point2D end = new Point2D.Double(
            start.getX() + Math.sin(alpha + Math.PI) * length,
            start.getY() + Math.cos(alpha + Math.PI) * length);
        g.draw(new Line2D.Double(start, end));
        drawTree(g, end, length * leftLengthFactor, minLength, 
            width * leftWidthFactor, alpha + leftAngleDelta);
        drawTree(g, end, length * rightLengthFactor, minLength, 
            width * rightWidthFactor, alpha + rightAngleDelta);
    }

    public void setLeftLengthFactor(double leftLengthFactor)
    {
        this.leftLengthFactor = leftLengthFactor;
        repaint();
    }

    public void setLeftWidthFactor(double leftWidthFactor)
    {
        this.leftWidthFactor = leftWidthFactor;
        repaint();
    }

    public void setLeftAngleDelta(double leftAngleDelta)
    {
        this.leftAngleDelta = leftAngleDelta;
        repaint();
    }

    public void setRightLengthFactor(double rightLengthFactor)
    {
        this.rightLengthFactor = rightLengthFactor;
        repaint();
    }

    public void setRightWidthFactor(double rightWidthFactor)
    {
        this.rightWidthFactor = rightWidthFactor;
        repaint();
    }

    public void setRightAngleDelta(double rightAngleDelta)
    {
        this.rightAngleDelta = rightAngleDelta;
        repaint();
    }

}