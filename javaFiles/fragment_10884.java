import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DisplayImage {
    public static void main(String[] args) {
        Image image;
        try {
            image = ImageIO.read(new File("C:/Users/User/Desktop/1.png"));
            JOptionPane.showMessageDialog(null, new ImageIcon(image));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to load image");
        }
    }
}