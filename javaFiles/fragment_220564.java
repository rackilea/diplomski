import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WarpImage {

    public static void main(String[] args) throws IOException {

        displayImage();
    }

    private static void displayImage() throws IOException{

        URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
        BufferedImage image = ImageIO.read(url);
        ImageIcon icon= new ImageIcon(image);
        JFrame frame=new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JLabel lbl= new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.pack();
        //check size :
        Rectangle bounds = lbl.getBounds();
        System.out.println(bounds.getWidth() +"-"+ bounds.getHeight());
        frame.setVisible(true);
    }
}