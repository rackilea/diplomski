import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WithRotation {

    private JFrame frame;
    private WavyPanel wp;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WithRotation();
            }
        });
    }

    public WithRotation() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Wavy!");
        wp = new WavyPanel();
        frame.add(wp, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        createAndStartTimers();
    }

    private void createAndStartTimers() {
        new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                wp.repaint();
            }
        }).start();
        new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                wp.tick();
            }
        }).start();
    }

    class WavyPanel extends JPanel {

        private final Dimension size = new Dimension(640, 480);
        private int amplitude = 50;
        private int frequency = 5;
        private double x1 = 0;
        private double y1 = 500;
        private int yBase = 0;

        WavyPanel() {
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.clearRect(0, 0, this.getSize().width, this.getSize().height);
            g2.setColor(Color.BLACK);

            Rectangle rect = new Rectangle((int) x1, (int) y1, 20, 80);

            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(-30), rect.getX() + rect.width / 2, rect.getY() + rect.height / 2);

            Shape transformed = transform.createTransformedShape(rect);
            g2.fill(transformed);
        }

        @Override
        public Dimension getPreferredSize() {
            return size;
        }

        @Override
        public Dimension getMinimumSize() {
            return size;
        }

        @Override
        public Dimension getMaximumSize() {
            return size;
        }

        public void tick() {
            x1 = x1 + 1;
            final int waveLength = size.width / frequency;
            yBase = (++yBase) % waveLength;
            final double normalized = (double) yBase / (double) waveLength;
            final double radians = normalized * Math.PI * 2;
            final double sine = Math.sin(radians);
            y1 = (int) (sine * amplitude);
        }
    }
}