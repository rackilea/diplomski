import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
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

        private Color color = Color.GREEN;

        private Point spot;

        public TestPane() {

            new Switcher().execute();

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

        public class Switcher extends SwingWorker<Void, Color> {

            @Override
            protected void process(List<Color> chunks) {
                color = chunks.get(chunks.size() - 1);
                repaint();
            }

            @Override
            protected Void doInBackground() throws Exception {

                while (true) {

                    publish(Color.GREEN);
                    Thread.sleep(2000);
                    publish(Color.YELLOW);
                    Thread.sleep(500);
                    publish(Color.RED);
                    Thread.sleep(2000);

                }

            }

        }

    }
}