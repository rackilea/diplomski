import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class BarChart
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

        final JSlider slider = new JSlider(1, 50, 3);
        final BarChartPanel barChartPanel = new BarChartPanel();
        slider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                barChartPanel.setNumberOfBars(slider.getValue());
            }
        });

        f.getContentPane().add(slider, BorderLayout.NORTH);
        f.getContentPane().add(barChartPanel, BorderLayout.CENTER);

        f.pack();
        f.setSize(600,600);
        f.setVisible(true);
    }
}


class BarChartPanel extends JPanel
{
    private int numberOfBars = 3;

    void setNumberOfBars(int n)
    {
        this.numberOfBars = n;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        Random random = new Random(0);
        int barWidth = getWidth() / numberOfBars - 1;
        int barsWidth = numberOfBars * (barWidth+1);
        int offsetX = (getWidth() - barsWidth) / 2;
        for (int b=0; b<numberOfBars; b++)
        {
            int x = offsetX + b * (barWidth + 1);
            int barHeight = random.nextInt(500);
            int y = getHeight() - barHeight;
            g.fillRect(x, y, barWidth, barHeight);
        }
    }
}