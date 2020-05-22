import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleTimer {

    public static void main(String[] args) {
        new SimpleTimer();
    }

    public SimpleTimer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Timer red;
        private Timer green;
        private Timer yellow;
        private Color color = Color.GREEN;

        private Point spot;

        public TestPane() {
            red = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = Color.RED;
                    green.start();
                    repaint();
                }
            });
            green = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = Color.GREEN;
                    yellow.start();
                    repaint();
                }
            });
            yellow = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    color = Color.YELLOW;
                    red.start();
                    repaint();
                }
            });
            red.setRepeats(false);
            green.setRepeats(false);
            yellow.setRepeats(false);
            green.start();

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    spot = e.getPoint();
                    repaint();
                }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int radius = 20;
            int x = (getWidth() - radius) / 2;
            int y = (getHeight() - radius) / 2;
            g2d.setColor(color);
            g2d.fillOval(x, y, radius, radius);

            if (spot != null) {

                x = spot.x - 5;
                y = spot.y - 5;
                g2d.setColor(Color.RED);
                g2d.drawOval(x, y, 10, 10);
                g2d.setColor(Color.YELLOW);
                g2d.fillOval(x, y, 10, 10);

            }

            g2d.dispose();
        }
    }
}