import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ConnectionPanel extends JPanel {

   private JTextField textField;
   private JButton connectButton;
   private ConnectionPanelControl control;

   public ConnectionPanel(final ConnectionPanelControl control) {
      super(new GridBagLayout());
      this.control = control;

      ActionListener listener = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (control != null) {
               control.connectButtonAction();
            }
         }
      };

      textField = new JTextField(14);
      textField.addActionListener(listener);
      textField.setText("/dev/ttyUSB0");

      connectButton = new JButton("Connect");

      GridBagConstraints c = new GridBagConstraints();
      c.gridwidth = GridBagConstraints.REMAINDER;

      c.fill = GridBagConstraints.HORIZONTAL;
      add(textField, c);

      c.fill = GridBagConstraints.BOTH;
      c.weightx = 1.0;
      c.weighty = 1.0;
      add(connectButton, c);

      connectButton.addActionListener(listener);
   }

   public String getFieldText() {
      return textField.getText();
   }

}