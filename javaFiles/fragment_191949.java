import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MovingSquareTest
{
    int x, y, size, step;
    MyPanel panel;
    Timer timer;

    public static final void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                MovingSquareTest app = new MovingSquareTest();
                app.createAndShowGUI();
                app.timer.start();
            }
        });
    }

    public MovingSquareTest()
    {
        x = 0;
        y = 150;
        size = 50;
        step = 50;

        timer = new Timer(500, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                x += step;
                if (x < 0) x = 0;
                if (x + size > panel.getWidth()) x = panel.getWidth() - size;
                if (x == 0 || x + size == panel.getWidth()) step *= -1;
                panel.repaint();
            }
        });
    }

    public void createAndShowGUI()
    {
        JFrame frame =  new JFrame("Dance, my square!");

        panel = new MyPanel();

        frame.add(panel);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private class MyPanel extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.drawRect(x, y, size, size);
        }
    }
}