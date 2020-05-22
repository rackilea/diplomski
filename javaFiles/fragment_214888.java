import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestRotation100 {

    public static void main(String[] args) {
        new TestRotation100();
    }

    public TestRotation100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final TestPane testPane = new TestPane();
                final JSlider slider = new JSlider(0, 3);
                slider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        testPane.setQuad(slider.getValue());
                    }
                });
                slider.setValue(0);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(testPane);
                frame.add(slider, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;
        private int quad = 0;

        public TestPane() {
            try {
                img = ImageIO.read(new File("/Users/swhitehead/Dropbox/MegaTokyo/Rampage_Small.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void setQuad(int quad) {
            this.quad = quad;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            AffineTransform at = new AffineTransform();
            at.translate(100, 40);
            at.quadrantRotate(quad, img.getWidth() / 2, img.getHeight() / 2);

            g2d.drawImage(img, at, this);

            g2d.dispose();
        }

    }

}