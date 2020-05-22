import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestDialog3 {
   private static void createAndShowGui() {
      MyLoginPanel3 myLoginPanel3 = new MyLoginPanel3();
      int result = JOptionPane.showConfirmDialog(null, myLoginPanel3, "Log On", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      if (result == JOptionPane.OK_OPTION) {
         String userName = myLoginPanel3.getUserName();
         char[] password = myLoginPanel3.getPassword();

         System.out.println("User Name: " + userName);
         System.out.println("Password:  " + new String(password));
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class MyLoginPanel3 extends JPanel {
   private static final int COLUMNS = 20;
   private JTextField userNameField = new JTextField(COLUMNS);
   private JPasswordField passField = new JPasswordField(COLUMNS);

   public MyLoginPanel3() {
      setLayout(new GridBagLayout());
      add(new JLabel("User Name:"), createGbc(0, 0, 1));
      add(userNameField, createGbc(1, 0, 2));
      add(new JLabel("Password:"), createGbc(0, 1, 1));
      add(passField, createGbc(1, 1, 2));
      add(new JLabel(""), createGbc(0, 2, 1));

   }

   private GridBagConstraints createGbc(int x, int y, int width) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = width;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      int right = x == 0 ? 15 : 5;
      gbc.insets = new Insets(5, 5, 5, right);
      gbc.anchor = x == 0 ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
      return gbc;
   }


   public String getUserName() {
      return userNameField.getText();
   }

   public char[] getPassword() {
      return passField.getPassword();
   }

}