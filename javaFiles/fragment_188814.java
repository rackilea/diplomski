import javax.swing.*;

public class InputVerifierEg {
   private JPanel mainPanel = new JPanel();
   private JTextField txtJobType = new JTextField(10);
   private JTextField txtPriorityCode = new JTextField(10);

   public InputVerifierEg() {
      txtJobType.setInputVerifier(new MyInputVerifier("jobType", "jobCode",
            JobType.class));
      txtPriorityCode.setInputVerifier(new MyInputVerifier("priority", "priorityCode",
            Priority.class));

      mainPanel.add(new JLabel("Job Type:"));
      mainPanel.add(txtJobType);
      mainPanel.add(Box.createHorizontalStrut(15));
      mainPanel.add(new JLabel("Priority Code:"));
      mainPanel.add(txtPriorityCode);

   }

   public JPanel getMainPanel() {
      return mainPanel;
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("InputVerifierEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new InputVerifierEg().getMainPanel());
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

class MyInputVerifier extends InputVerifier {
   private String fieldName;
   private String codeName;
   private Class<?> classType;

   public MyInputVerifier(String fieldName, String codeName, Class<?> classType) {
      this.fieldName = fieldName;
      this.codeName = codeName;
      this.classType = classType;
   }

   @Override
   public boolean verify(JComponent input) {
      JTextField tField = (JTextField) input;

      // assuming that the checkFieldExists is a static method of a utility class
      if (!FieldCheckerUtil.checkFieldExists(tField.getText(), fieldName,
            codeName, classType)) {
         return false;
      }

      if (tField.getText().trim().isEmpty()) {
         return false;
      }
      return true;
   }

   @Override
   public boolean shouldYieldFocus(JComponent input) {
      JTextField tField = (JTextField) input;

      if (verify(input)) {
         return true;
      } else {
         tField.selectAll();
         // show JOptionPane error message?
         return false;
      }
   }
}