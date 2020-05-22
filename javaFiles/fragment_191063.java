import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingTest {

    SwingTest() {

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        BufferedImage img = null;
        try {
            URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
            img = ImageIO.read(url);
        } catch (IOException ex) {  ex.printStackTrace();}

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "JPEG", baos);
        } catch (IOException ex) {ex.printStackTrace();      }

        frame.add(new JLabel(new ImageIcon(img)));
        frame.add(new JLabel(new ImageIcon(baos.toByteArray())));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main (String[] agrs) {
        new SwingTest();
    }
}