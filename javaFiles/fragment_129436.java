import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class MySkeleton extends JPanel {
   private static final int COLUMN_COUNT = 10;
   private static final int I_GAP = 3;
   private JTextField userNameField = new JTextField();
   private JPasswordField passwordField = new JPasswordField();

   public MySkeleton() {
      super(new GridBagLayout());
      userNameField.setColumns(COLUMN_COUNT);
      passwordField.setColumns(COLUMN_COUNT);

      GridBagConstraints gbc = getGbc(0, 0, GridBagConstraints.BOTH);
      add(new JLabel("User Name:"), gbc);
      gbc = getGbc(1, 0, GridBagConstraints.HORIZONTAL);
      add(userNameField, gbc);
      gbc = getGbc(0, 1, GridBagConstraints.BOTH);
      add(new JLabel("Password:"), gbc);
      gbc = getGbc(1, 1, GridBagConstraints.HORIZONTAL);
      add(passwordField, gbc);
   }

   public static GridBagConstraints getGbc(int x, int y, int fill) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);
      gbc.fill = fill;

      return gbc;
   }

   public String getUserName() {
      return userNameField.getText();
   }

   public char[] getPassword() {
      return passwordField.getPassword();
   }
}