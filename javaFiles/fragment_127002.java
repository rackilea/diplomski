import java.awt.*;
import javax.swing.*;

 public class DemoJTextFieldWithLimit extends JApplet{
   JTextField textfield1;
   JLabel label1;

   public void init() {
     getContentPane().setLayout(new FlowLayout());
     //
     label1 = new JLabel("max 10 chars");
     textfield1 = new JTextField(15);
     getContentPane().add(label1);
     getContentPane().add(textfield1);
     textfield1.setDocument
        (new JTextFieldLimit(10));
     }
}