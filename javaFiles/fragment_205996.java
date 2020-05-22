import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SlidingAnimation {

    public static void main(String[] args) {
        new SlidingAnimation();
    }

    public SlidingAnimation() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;

        private Timer timer;
        private long startTime = -1;
        private int playTime = 4000;

        private float progress;

        public TestPane() {
            try {
                img = ImageIO.read(new File("..."));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime == -1) {
                        startTime = System.currentTimeMillis();
                    } else {
                        long currentTime = System.currentTimeMillis();
                        long diff = currentTime - startTime;

                        if (diff >= playTime) {
                            diff = 0;
                            startTime = -1;
                        }
                        progress = diff / (float) playTime;
                    }

                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        protected BufferedImage generateImage() {

            BufferedImage buffer = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = buffer.createGraphics();
            g2d.setBackground(new Color(0, 0, 0, 0));
            g2d.clearRect(0, 0, buffer.getWidth(), buffer.getHeight());
            g2d.drawImage(img, 0, 0, this);

            float startAt = progress - 0.05f;
            float endAt = progress + 0.05f;

            if (endAt <= 0.1f) {
                startAt = 0;
                endAt = Math.max(0.1f, progress);
            } else if (endAt >= 1f) {
                endAt = 1f;
                startAt = progress;
            }

            LinearGradientPaint lgp = new LinearGradientPaint(
                    new Point2D.Float(0, 0),
                    new Point2D.Float(img.getWidth(), 0),
                    new float[]{startAt, endAt},
                    new Color[]{new Color(0, 0, 0, 0), Color.RED});

            g2d.setPaint(lgp);

            g2d.setComposite(AlphaComposite.DstOut.derive(1f));
            g2d.fill(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
            g2d.dispose();

            return buffer;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int y = (getHeight() - img.getHeight()) / 2;
                int x = (getWidth() - img.getWidth()) / 2;
                g2d.drawImage(generateImage(), x, y, this);

                g2d.dispose();
            }
        }

    }

}