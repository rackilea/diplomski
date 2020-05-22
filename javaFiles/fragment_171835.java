import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoWindowEg {
   private static void createAndShowUI() {
      JFrame frame = new JFrame("Two Window Eg");
      frame.getContentPane().add(new MainPanel());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

class MainPanel extends JPanel {
   private JTextField textField = new JTextField(20);
   private DialogPanel dialogPanel = null;

   public MainPanel() {
      textField.setEditable(false);
      textField.setFocusable(false);
      textField.setBackground(Color.white);

      JButton openDialogBtn = new JButton("Open Dialog");
      openDialogBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (dialogPanel == null) {
               dialogPanel = new DialogPanel();
            }
            int result = JOptionPane.showConfirmDialog(MainPanel.this, dialogPanel,
                     "Enter First and Last Name", JOptionPane.OK_CANCEL_OPTION,
                     JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
               String text = dialogPanel.getText();
               textField.setText(text);
            }

         }
      });

      add(textField);
      add(openDialogBtn);

      setPreferredSize(new Dimension(400, 300));
      setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
   }
}

class DialogPanel extends JPanel {
   private static final Insets INSETS = new Insets(0, 10, 0, 10);
   private JTextField firstNameField = new JTextField(10);
   private JTextField lastNameField = new JTextField(10);

   public DialogPanel() {
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
               GridBagConstraints.LINE_START, GridBagConstraints.BOTH, 
               INSETS, 0, 0);
      add(new JLabel("First Name"), gbc);
      gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,
               GridBagConstraints.LINE_END, GridBagConstraints.BOTH, 
               INSETS, 0, 0);
      add(new JLabel("Last Name"), gbc);
      gbc = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
               GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, 
               INSETS, 0, 0);
      add(firstNameField, gbc);

      gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0,
               GridBagConstraints.LINE_END, GridBagConstraints.HORIZONTAL, 
               INSETS, 0, 0);
      add(lastNameField, gbc);
   }

   public String getText() {
      return firstNameField.getText() + " " + lastNameField.getText();
   }
}