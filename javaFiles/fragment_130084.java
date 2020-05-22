import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class UserIdPasswordPanel extends JPanel {
   JTextField selectionField = new JTextField(10);
   JTextField userIDField = new JTextField(10);
   JTextField passwordField = new JTextField(10);

   public UserIdPasswordPanel(JFrame frame) {
      add(new JButton(new AbstractAction("Login") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            LoginPane loginPane = new LoginPane(UserIdPasswordPanel.this,
                  "My Login Panel");
            int result = loginPane.show();
            System.out.println("" + result);
            if (result >= 0) {
               String selectionText = LoginPane.options[result].toString();
               if (selectionText.equals(LoginPane.LOGIN)) {
                  System.out.println("do some login action here");
               } else if (selectionText.equals(LoginPane.RESET)) {
                  System.out.println("do some reset action here");
               }

               // just to show that this works:
               selectionField.setText(selectionText);
               userIDField.setText(loginPane.getUserId());

               // !! never do this !!!!!
               passwordField.setText(new String(loginPane.getPassword()));
            }
         }
      }));
      selectionField.setEditable(false);
      userIDField.setEditable(false);
      passwordField.setEditable(false);
      add(new JLabel("Selection: "));
      add(selectionField);
      add(new JLabel("ID: "));
      add(userIDField);
      add(new JLabel("Password: "));
      add(passwordField);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("UserIdPasswordPanel");

      UserIdPasswordPanel mainPanel = new UserIdPasswordPanel(frame);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class LoginPane {
   public static final String LOGIN = "Login";
   public static final String RESET = "Reset";
   public static final Object[] options = { LOGIN, RESET };
   private JTextField userIdField = new JTextField(10);
   private JPasswordField passwordField = new JPasswordField(10);
   private Component parent;
   private String title;
   private JPanel message = new JPanel();

   public LoginPane(Component parent, String title) {
      this.parent = parent;
      this.title = title;

      message.setLayout(new GridBagLayout());

      GridBagConstraints gbc = getGbc(0, 0);
      message.add(new JLabel("User ID:"), gbc);
      gbc = getGbc(1, 0);
      message.add(userIdField, gbc);
      gbc = getGbc(0, 1);
      message.add(new JLabel("Password:"), gbc);
      gbc = getGbc(1, 1);
      message.add(passwordField, gbc);
   }

   private GridBagConstraints getGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
      return gbc;
   }

   public String getUserId() {
      return userIdField.getText();
   }

   public char[] getPassword() {
      return passwordField.getPassword();
   }

   public int show() {
      Object initialValue = "Login";
      return JOptionPane.showOptionDialog(parent, message, title,
            JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            options, initialValue);
   }
}