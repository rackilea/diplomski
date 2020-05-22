package codePackage;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ClassUsesResources {
   private JLabel label = new JLabel();

   public ClassUsesResources() {
      try {
         BufferedImage img = ImageIO.read(getClass().getResourceAsStream(
               "images/img001s.jpg"));
         ImageIcon icon = new ImageIcon(img);
         label.setIcon(icon);

         JOptionPane.showMessageDialog(null, label);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

   public static void main(String[] args) {
      new ClassUsesResources();
   }
}