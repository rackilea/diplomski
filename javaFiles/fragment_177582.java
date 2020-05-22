import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import javax.swing.*;

public class TestDialog2 {
   private static void createAndShowGui() {
      int result = MyLoginPanel.showDialog();
      if (result == JOptionPane.OK_OPTION) {
         String userName = MyLoginPanel.getUserName();
         char[] password = MyLoginPanel.getPassword();

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
class MyLoginPanel extends JPanel {
   private static MyLoginPanel myLoginPanel = new MyLoginPanel();
   private static JDialog myDialog;
   public static final String RETURN_STATE = "return state";
   private static final int COLUMNS = 20;
   private JTextField userNameField = new JTextField(COLUMNS);
   private JPasswordField passField = new JPasswordField(COLUMNS);
   private int returnState = Integer.MIN_VALUE;

   private MyLoginPanel() {
      setLayout(new GridBagLayout());
      add(new JLabel("User Name:"), createGbc(0, 0, 1));
      add(userNameField, createGbc(1, 0, 2));
      add(new JLabel("Password:"), createGbc(0, 1, 1));
      add(passField, createGbc(1, 1, 2));
      add(new JLabel(""), createGbc(0, 2, 1));

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));

      buttonPanel.add(new JButton(new LoginAction("Login")));
      buttonPanel.add(new JButton(new CancelAction("Cancel")));

      add(buttonPanel, createGbc(1, 2, 2));
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

   public void setReturnState(int returnState) {
      this.returnState = returnState;
      firePropertyChange(RETURN_STATE, Integer.MIN_VALUE, returnState);
   }

   public int getReturnState() {
      return returnState;
   }

   private class LoginAction extends AbstractAction {
      public LoginAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         returnState = JOptionPane.OK_OPTION;
         Window win = SwingUtilities.getWindowAncestor(MyLoginPanel.this);
         win.dispose();
      }
   }

   private String _getUserName() {
      return userNameField.getText();
   }

   private char[] _getPassword() {
      return passField.getPassword();
   }

   public static String getUserName() {
      return myLoginPanel._getUserName();
   }

   public static char[] getPassword() {
      return myLoginPanel._getPassword();
   }

   private class CancelAction extends AbstractAction {
      public CancelAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         returnState = JOptionPane.CANCEL_OPTION;
         Window win = SwingUtilities.getWindowAncestor(MyLoginPanel.this);
         win.dispose();
      }
   }

   public static int showDialog() {
      if (myDialog == null) {
         myDialog = new JDialog(null, "Test", ModalityType.APPLICATION_MODAL);
         myDialog.add(myLoginPanel);
         myDialog.pack();
      }
      myDialog.setVisible(true);
      return myLoginPanel.getReturnState();
   }

}