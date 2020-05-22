import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


class ColorRange
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
        f.getContentPane().add(new ColorRangePanel());
        f.setSize(1000, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


class ColorRangePanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        double values[] = {
            -1e3, -1e2, -1e1, -1, -0.5, 0.0, 0.5, 1, 1e1, 1e2, 1e3    
        };

        for (int i=0; i<values.length; i++)
        {
            double value = values[i];
            int w = getWidth() / values.length;
            int x = i * w;

            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(value), x, 20);

            g.setColor(colorFor(value));
            g.fillRect(x, 50, w, 100);
        }
    }

    private static Color colorFor(double value) 
    {
        double v0 = value / Math.sqrt(1 + value * value); // -1...1
        double v1 = (1 + v0) * 0.5; // 0...1
        return colorForRange(v1);
    }    
    private static Color colorForRange(double value) 
    {
        value = Math.max(0, Math.min(1, value));
        int red = (int)(value * 255);
        return new Color(red,0,0);
    }    
}