import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class MyClass {
   private static final String RESOURCE_PATH = "images/GridBoxClassPic.JPG";

   public MyClass() {
      try {
         BufferedImage image = ImageIO.read(getClass().getResource(RESOURCE_PATH));
         ImageIcon icon = new ImageIcon(image);
         JLabel label = new JLabel(icon);
         JOptionPane.showMessageDialog(null, label);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new MyClass();
   }
}