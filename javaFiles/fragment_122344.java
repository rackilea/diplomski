import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestFading {

    private static class FadingPanel extends JPanel {
        private BufferedImage buffer;
        private boolean isFading = false;
        private long start;
        private float alpha = 1.0f;

        @Override
        public void paint(Graphics g) {
            if (isFading) {// During fading, we prevent child components from being painted
                g.clearRect(0, 0, getWidth(), getHeight());
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g.drawImage(buffer, 0, 0, this);// We only draw an image of them with an alpha
            } else {
                super.paint(g);
            }
        }

        public void fade(int time) {
            start = System.currentTimeMillis();
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            this.print(buffer.getGraphics());// Draw the current components on the buffer
            isFading = true;
            final int timeInMillis = time * 1000;
            final Timer t = new Timer(50, null);
            t.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    long elapsed = System.currentTimeMillis() - start;
                    if (elapsed > timeInMillis) {
                        start = 0;
                        isFading = false;
                        buffer = null;
                        repaint();
                        t.stop();
                    } else {
                        alpha = 1.0f - (float) elapsed / timeInMillis;
                        repaint();
                    }
                }
            });
            t.start();
        }
    }

    protected void initUI() throws MalformedURLException {
        JFrame frame = new JFrame(TestFading.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final FadingPanel panel = new FadingPanel();
        JTextField textfield = new JTextField(60);
        JLabel image = new JLabel(new ImageIcon(new URL("http://helios.gsfc.nasa.gov/image_mag_stamp.jpg")));
        JButton button = new JButton("Fade");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // I use an invoke later to allow the button to release itself
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        panel.fade(5);// Fade the panel in 5s.
                    }
                });
            }
        });
        panel.add(textfield);
        panel.add(image);
        panel.add(button);
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new TestFading().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}