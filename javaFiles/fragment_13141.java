import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class NegativeImage {

    public static void main(String[] args) {
        new NegativeImage();
    }

    public NegativeImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
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

        private BufferedImage img;

        public TestPane() {
            try {
                img = ImageIO.read(new File("/Users/swhitehead/Dropbox/MegaTokyo/Evil_Small.jpg"));
            } catch (IOException ex) {
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight()- img.getHeight()) / 2;
            // Center...
            g.drawImage(img, x, y, this);

            // Off to the left...
            x = -(img.getWidth() / 2);
            g.drawImage(img, x, y, this);

            // Off to the right...
            x = getWidth() - (img.getWidth() / 2);
            g.drawImage(img, x, y, this);
        }        
    }    
}