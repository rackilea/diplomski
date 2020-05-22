import javax.swing.*;
import java.awt.event.*;

public class Foo {
  public static void main(String args[]) {
    // Create a "clickable" image icon.
    ImageIcon icon = new ImageIcon("path/to/image.jpg");
    JLabel label = new JLabel(icon);
    label.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent me) {
        System.out.println("CLICKED");
      }
    });

    // Add it to a frame.
    JFrame frame = new JFrame("My Window");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(label);
    frame.pack();
    frame.setVisible(true);
  }
}