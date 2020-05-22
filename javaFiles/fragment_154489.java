import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Eevento {
   public static void main(String[] args){
      JFrame frame = new JFrame("Wumbleton");
      Container content = frame.getContentPane();
      JButton button1 = new JButton("Press this");
      content.add(button1, BorderLayout.NORTH);
      button1.addMouseListener(new MouseAdapter(){ // parentheses added
          public void mousePressed(MouseEvent e){
               System.out.println("button 1 has been pressed");
          }
      });
      frame.setSize(500,500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}