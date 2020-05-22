import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowImage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Debug Frame");
        frame.setSize(200, 200);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image image = null;
        JLabel label = null;

        try {
            image = ImageIO.read(new File("c:/scratch/hotdog.jpg"));
            label = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            label.setText("Image loading failed");
        }

        frame.add(label,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}