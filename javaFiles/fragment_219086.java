import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SpiralDrawPanelTest
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
        f.getContentPane().add(new SpiralDrawPanel(),BorderLayout.CENTER);
        f.setSize(800, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class SpiralDrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        AffineTransform at = 
            AffineTransform.getTranslateInstance(
                getWidth()/2, getHeight()/2);

        BasicStroke stroke =
            new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, new float[]{10.0f}, 0.0f);
        g.setStroke(stroke);
        Shape shape = 
            at.createTransformedShape(
                createArchimedeanSpiral(Math.PI*10, 10, 250));
        g.draw(shape);

    }

    private static Shape createArchimedeanSpiral(
        double totalAngleRad, double alpha, int steps)
    {
        Path2D path = new Path2D.Double();
        path.moveTo(0, 0);
        double angleDeltaRad = totalAngleRad / steps;
        for (int i=0; i<=steps; i++)
        {
            double angleRad = i * angleDeltaRad;
            double x = Math.sin(angleRad) * alpha * angleRad;
            double y = Math.cos(angleRad) * alpha * angleRad;
            path.lineTo(x, y);
        }
        return path;

    }
}