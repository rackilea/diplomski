import java.awt.BorderLayout;
import java.awt.Graphics;
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
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        paintArchimedeanSpiral(g, getWidth()/2,  getHeight()/2, Math.PI * 10, 10, 250);
    }

    private static void paintArchimedeanSpiral(
        Graphics g, 
        double centerX, double centerY,
        double totalAngleRad, double alpha, int steps)
    {
        Path2D path = new Path2D.Double();
        path.moveTo(0, 0);
        double angleDeltaRad = totalAngleRad / steps;
        for (int i=0; i<=steps; i+=2)
        {
            double angleRad0 = i * angleDeltaRad;
            double angleRad1 = i * angleDeltaRad + angleDeltaRad;
            double x0 = centerX + Math.sin(angleRad0) * alpha * angleRad0;
            double y0 = centerY + Math.cos(angleRad0) * alpha * angleRad0;
            double x1 = centerX + Math.sin(angleRad1) * alpha * angleRad1;
            double y1 = centerY + Math.cos(angleRad1) * alpha * angleRad1;
            g.drawLine((int)x0, (int)y0, (int)x1, (int)y1);
        }
    }
}