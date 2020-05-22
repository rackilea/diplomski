import java.awt.event.*;
import javax.swing.*;

public class YourDialog extends JDialog implements ActionListener {

  JButton button;

  public YourDialog() {
     button = new JButton("Close");
     button.addActionListener(this);
     add(button);
     pack();
     setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
      dispose();
  }
}