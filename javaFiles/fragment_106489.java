import java.awt.*;
import javax.swing.*;

public class TestUnderscore 
{
  // Test routine.
  public static void main(String[] args) 
  {
    JFrame frame = new JFrame();
    frame.getContentPane().setBackground(Color.yellow);
    frame.getContentPane().add(new JLabel("Test_Underscore$$"));
    frame.getContentPane().setLayout(new FlowLayout());
    frame.setSize(450, 450);
    frame.setVisible(true);
  }
}