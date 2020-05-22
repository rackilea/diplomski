import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BlinkNode {

    public static void main(String[] args) {
        new BlinkNode();
    }

    public BlinkNode() {
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

        // Animation stuff
        private Timer aniTimer;
        // The amount of time that each animation cycle plays for 
        // in millis
        private int aniRunTime = 1000;
        // The time the animation was started
        private long startTime = -1;

        // Our color ranges, where to start and where
        // we want to get to and the current state...
        private Color startColor;
        private Color targetColor;
        private Color color;

        public TestPane() {
            // Initial state
            startColor = getBackground();
            targetColor = Color.GREEN;
            color = startColor;
            aniTimer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Set the start time it hasn't already
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    // We're always finished if we run over time...
                    float progress = 1f;
                    // Calculate the duration of play
                    long duration = System.currentTimeMillis() - startTime;
                    // Have we reached the end yet??
                    if (duration >= aniRunTime) {
                        // Reset the start time, this allows the 
                        // animation to cycle.  Normally you would stop
                        // the timer, see the previous example
                        startTime = -1;
                        // Swap the start and target colors...
                        Color tmp = startColor;
                        startColor = targetColor;
                        targetColor = tmp;
                        color = startColor;
                    } else {
                        // Calculate the progress
                        progress = (float) duration / (float) aniRunTime;
                        // Blend the colors
                        color = blend(startColor, targetColor, 1f - progress);
                    }
                    // update the ui
                    repaint();
                }
            });
            aniTimer.setRepeats(true);
            aniTimer.setCoalesce(true);
            aniTimer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int x = (getWidth() - 20) / 2;
            int y = (getHeight() - 20) / 2;
            g2d.setColor(color);
            Ellipse2D node = new Ellipse2D.Float(x, y, 20, 20);
            g2d.fill(node);
            g2d.setColor(Color.GRAY);
            g2d.draw(node);

            g2d.dispose();
        }
    }

    public static Color blend(Color color1, Color color2, double ratio) {
        float r = (float) ratio;
        float ir = (float) 1.0 - r;

        float rgb1[] = new float[3];
        float rgb2[] = new float[3];

        color1.getColorComponents(rgb1);
        color2.getColorComponents(rgb2);

        float red = rgb1[0] * r + rgb2[0] * ir;
        float green = rgb1[1] * r + rgb2[1] * ir;
        float blue = rgb1[2] * r + rgb2[2] * ir;

        if (red < 0) {
            red = 0;
        } else if (red > 255) {
            red = 255;
        }
        if (green < 0) {
            green = 0;
        } else if (green > 255) {
            green = 255;
        }
        if (blue < 0) {
            blue = 0;
        } else if (blue > 255) {
            blue = 255;
        }

        Color color = null;
        try {

            color = new Color(red, green, blue);

        } catch (IllegalArgumentException exp) {

            NumberFormat nf = NumberFormat.getNumberInstance();
            System.err.println(nf.format(red) + "; " + nf.format(green) + "; " + nf.format(blue));

        }
        return color;
    }
}