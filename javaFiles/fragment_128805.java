import javax.swing.*;
import java.awt.*;

 public class Canvas extends JPanel {

   // TODO member variables for rectangle size/color

   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.fillRect(10,10,100,50);
     g.drawRect(10,80,100,50);
  }
}