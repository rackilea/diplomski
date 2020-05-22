import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class NimbusTest {

    public static void main(String[] args) {
        new NimbusTest();
    }

    public NimbusTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(new TestTextArea()));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestTextArea extends JTextArea {

        private BufferedImage bg;

        public TestTextArea() {
            try {
                bg = ImageIO.read(new File("C:\\Users\\swhitehead\\Documents\\My Dropbox\\Ponies\\Rainbow_Dash_flying_past_3_S2E16.png"));
            } catch (IOException ex) {
                Logger.getLogger(NimbusTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            // Fill the background, this is VERY important
            // fail to do this and you will have major problems
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            // Draw the background
            g2d.drawImage(bg, 0, 0, this);
            // Paint the component content, ie the text
            getUI().paint(g2d, this);
            g2d.dispose();
        }

    }
}