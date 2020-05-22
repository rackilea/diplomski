import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestBackgroundResize {
    public TestBackgroundResize() {
        JFrame frame = new JFrame();
        frame.setContentPane(createBackgroundPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createBackgroundPanel() {
        return new JPanel() {
            BufferedImage image;
            {
                try {
                    image = ImageIO.read(getClass().getResource("/marioblobs/mario.png"));
                } catch (IOException ex) {
                    Logger.getLogger(TestBackgroundResize.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 200);
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestBackgroundResize();
            }
        });
    }
}