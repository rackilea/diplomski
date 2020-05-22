import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SizeFoo {

   public static void main(String[] args) {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Rectangle rect = new Rectangle(screenSize.width / 2 - screenSize.width
            / 4, screenSize.height / 2 - screenSize.height / 4,
            screenSize.width / 2, screenSize.height / 2);
      System.out.println("rect: " + rect);
      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(rect.width, rect.height));
      frame.setResizable(false);
      frame.pack();
      frame.setLocation(rect.x, rect.y);
      //frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      System.out.println("JFrame size:" + frame.getSize());
   }
}