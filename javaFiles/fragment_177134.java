import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ColorCycle {
    private static class ColorPanel extends JPanel {
        private final float stepSize;
        private final Timer timer;
        private int index;

        ColorPanel(final int steps, int fps) {
            stepSize = 1f / steps;
            timer = new Timer(1000 / fps, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    index++;
                    if (index > steps) {
                        index = 0;
                    }
                    repaint();
                }
            });
        }

        void start() {
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.getHSBColor(index * stepSize, 1f,  1f));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Colors");
                ColorPanel panel = new ColorPanel(300, 20);
                frame.getContentPane().add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setVisible(true);
                panel.start();  
            }
        });
    }
}