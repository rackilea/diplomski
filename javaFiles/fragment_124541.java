// the imports required
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

//paste this method in your class and call it when you want to display image

public void showImage(String path_to_image)
{
 JFrame frame = new JFrame("Image");
 frame.setLayout(new BorderLayout());
 frame.setResizable(false);
 ImageIcon myImage = new ImageIcon(path_to_image);
 frame.getContentPane().add(new JLabel(myImage)); 

 frame.pack();
 frame.setVisible(true);
}