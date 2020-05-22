import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class InputVerifierExample extends JPanel {
   public static final Color WARNING_COLOR = Color.red;
   private JTextField firstNameField = new JTextField(10);
   private JTextField middleNameField = new JTextField(10);
   private JTextField lastNameField = new JTextField(10);
   private JTextField[] nameFields = { 
         firstNameField, 
         middleNameField,
         lastNameField };
   private JLabel warningLabel = new JLabel("  ");

   public InputVerifierExample() {
      warningLabel.setOpaque(true);

      JPanel namePanel = new JPanel();
      namePanel.add(new JLabel("Name:"));
      MyInputVerifier verifier = new MyInputVerifier();
      for (JTextField field : nameFields) {
         field.setInputVerifier(verifier);
         namePanel.add(field);
      }
      namePanel.add(new JButton(new SubmitBtnAction()));

      setLayout(new BorderLayout());
      add(namePanel, BorderLayout.CENTER);
      add(warningLabel, BorderLayout.SOUTH);
   }

   private class SubmitBtnAction extends AbstractAction {
      public SubmitBtnAction() {
         super("Submit");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // first check all fields aren't empty
         for (JTextField field : nameFields) {
            if (field.getText().trim().isEmpty()) {
               return;  // return if empty
            }
         }
         String name = "";
         for (JTextField field : nameFields) {
            name += field.getText() + " ";
            field.setText("");
         }
         name = name.trim();
         JOptionPane.showMessageDialog(InputVerifierExample.this, name, "Name Entered",
               JOptionPane.INFORMATION_MESSAGE);
      }
   }

   private class MyInputVerifier extends InputVerifier {

      @Override
      public boolean verify(JComponent input) {
         JTextField field = (JTextField) input;
         if (field.getText().trim().isEmpty()) {
            warningLabel.setText("Please do not leave this field empty");
            warningLabel.setBackground(WARNING_COLOR);
            return false;
         }
         warningLabel.setText("");
         warningLabel.setBackground(null);
         return true;
      }

   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("InputVerifier Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new InputVerifierExample());
      frame.pack();
      frame.setLocationRelativeTo(null);
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