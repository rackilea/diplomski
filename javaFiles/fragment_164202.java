import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class InputForm extends JPanel {
   private static final int COLUMNS = 10;
   private static final int GAP = 3;
   private static final Insets LABEL_INSETS = new Insets(GAP, GAP, GAP, 15);
   private static final Insets TEXTFIELD_INSETS = new Insets(GAP, GAP, GAP, GAP);
   private String[] labelTexts;
   private Map<String, JTextField> fieldMap = new HashMap<String, JTextField>();

   public InputForm(String[] labelTexts) {
      this.labelTexts = labelTexts;
      setLayout(new GridBagLayout());
      for (int i = 0; i < labelTexts.length; i++) {
         String text = labelTexts[i];
         JTextField field = new JTextField(COLUMNS);
         fieldMap.put(text, field);

         addLabel(text, i);
         addTextField(field, i);
      }
   }

   public String[] getLabelTexts() {
      return labelTexts;
   }

   private void addTextField(JTextField field, int row) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.gridx = 1;
      gbc.gridy = row;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = TEXTFIELD_INSETS;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      add(field, gbc);
   }

   private void addLabel(String text, int row) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.gridx = 0;
      gbc.gridy = row;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = LABEL_INSETS;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      add(new JLabel(text), gbc);
   }

   public String getFieldText(String key) {
      String text = "";
      JTextField field = fieldMap.get(key);
      if (field != null) {
         text = field.getText();
      }
      return text;
   }

   private static void createAndShowGui() {
      String[] labelTexts = new String[] { "Width of Frame:",
            "Height of Frame:", "# OF Balls:", "Color:" };
      InputForm inputForm = new InputForm(labelTexts);

      int result = JOptionPane.showConfirmDialog(null, inputForm, "Input Form",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      if (result == JOptionPane.OK_OPTION) {
         for (String text : labelTexts) {
            System.out.printf("%20s %s%n", text, inputForm.getFieldText(text));
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