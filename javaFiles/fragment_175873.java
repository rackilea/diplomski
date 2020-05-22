import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SlideShow {

    public SlideShow() {
        final CardLayout layout = new CardLayout();
        final JPanel mainPanel = createMainPanel(layout);

        Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                layout.next(mainPanel);
            }
        });
        timer.start();

        JFrame frame = new JFrame();
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createMainPanel(CardLayout layout) {
        JPanel panel = new JPanel(layout);
        panel.add(new ImagePanel("mario.png"));
        panel.add(new ImagePanel("bowser.png"));
        panel.add(new ImagePanel("luigi.png"));
        panel.add(new ImagePanel("koopa.png"));
        panel.add(new ImagePanel("princess.png"));
        return panel;
    }

    private class ImagePanel extends JPanel {

        BufferedImage image;

        public ImagePanel(String fileName) {
            try {
                image = ImageIO.read(getClass().getResource("/marioblobs/" + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? new Dimension(200, 200) 
                    : new Dimension(image.getWidth(), image.getHeight());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SlideShow();
            }
        });
    }
}