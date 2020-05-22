import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Display extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Display());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private MovableObject object = new MovableObject(new Ellipse2D.Double(5, 5, 50, 50));
    private int delay = 40;

    private Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            object.evaluatePosition(getSize());
            repaint();
        }
    });

    private JSlider slider = new JSlider(5, 1000);

    public Display() {
        object.move(50, 50);

        slider = new JSlider(5, 1000);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        setLayout(new BorderLayout());
        add(slider, BorderLayout.SOUTH);

        // This is simply designed to put an artificate delay between the
        // change listener and the time the update takes place, the intention
        // is to stop it from pausing the "main" timer...
        Timer delay = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null) {
                    timer.stop();
                }
                timer.setDelay(slider.getValue());
                timer.start();
            }
        });

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                delay.restart();
                repaint();
            }
        });

        slider.setValue(40);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(object.getTranslatedShape());
        FontMetrics fm = g2.getFontMetrics();
        String text = Integer.toString(slider.getValue());
        g2.drawString(text, 0, fm.getAscent());
        g2.dispose();
    }

    public class MovableObject {

        private Shape shape;
        private Point location;

        private int xDelta, yDelta;

        public MovableObject(Shape shape) {
            this.shape = shape;
            location = shape.getBounds().getLocation();
            Random rnd = new Random();
            xDelta = rnd.nextInt(8);
            yDelta = rnd.nextInt(8);

            if (rnd.nextBoolean()) {
                xDelta *= -1;
            }
            if (rnd.nextBoolean()) {
                yDelta *= -1;
            }
        }

        public void move(int x, int y) {
            location.setLocation(x, y);
        }

        public void evaluatePosition(Dimension bounds) {
            int x = location.x + xDelta;
            int y = location.y + yDelta;

            if (x < 0) {
                x = 0;
                xDelta *= -1;
            } else if (x + shape.getBounds().width > bounds.width) {
                x = bounds.width - shape.getBounds().width;
                xDelta *= -1;
            }
            if (y < 0) {
                y = 0;
                yDelta *= -1;
            } else if (y + shape.getBounds().height > bounds.height) {
                y = bounds.height - shape.getBounds().height;
                yDelta *= -1;
            }

            location.setLocation(x, y);
        }

        public Shape getTranslatedShape() {
            PathIterator pi = shape.getPathIterator(AffineTransform.getTranslateInstance(location.x, location.y));
            GeneralPath path = new GeneralPath();
            path.append(pi, true);
            return path;
        }

    }
}