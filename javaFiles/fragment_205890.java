import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.*;

public class Project2 {
   private static final int COLUMN_COUNT = 10;
   private static final int I_GAP = 3;
   private JTextField userNameField = new JTextField();
   private JPasswordField passwordField = new JPasswordField();
   private JPanel mainPanel = new JPanel(new GridBagLayout());

   public Project2() {
      userNameField.setColumns(COLUMN_COUNT);
      passwordField.setColumns(COLUMN_COUNT);

      GridBagConstraints gbc = getGbc(0, 0, GridBagConstraints.BOTH);
      mainPanel.add(new JLabel("User Name:"), gbc);
      gbc = getGbc(1, 0, GridBagConstraints.HORIZONTAL);
      mainPanel.add(userNameField, gbc);
      gbc = getGbc(0, 1, GridBagConstraints.BOTH);
      mainPanel.add(new JLabel("Password:"), gbc);
      gbc = getGbc(1, 1, GridBagConstraints.HORIZONTAL);
      mainPanel.add(passwordField, gbc);
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

   public JComponent getMainPanel() {
      return mainPanel;
   }

   private static void createAndShowGui() {
      Project2 project2 = new Project2();

      int input = JOptionPane.showConfirmDialog(null, project2.getMainPanel(),
            "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      if (input == JOptionPane.OK_OPTION) {
         if (project2.getUserName().equals("root") && 
               Arrays.equals(project2.getPassword(), "11223344".toCharArray())) {
            // you're good
         } else {
            JOptionPane.showMessageDialog(project2.getMainPanel(),
                  "error message", "Error Title", JOptionPane.ERROR_MESSAGE);
         }
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