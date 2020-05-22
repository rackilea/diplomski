import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("serial")
public class SendEmail extends JDialog {
   public final static String[] LABEL_TEXTS = { "Select an Account:", "To:",
         "BCC:", "CC:", "Subject:" };
   public final static String[] ACCOUNT_TEXTS = { "Yahoo", "GMail", "MSN" };
   private static final int TEXT_FIELD_LENGTH = 20;
   private static final int T_AREA_ROWS = 20;
   private static final int T_AREA_COLS = 50;
   private static final int INSET_GAP = 1;
   private static final int RIGHT_INSET_GAP = 15;
   private Map<String, JTextField> fieldMap = new HashMap<String, JTextField>();
   private JTextArea messageTxt;
   private JButton send;

   private JComboBox<String> accountBox;

   private JScrollPane scroll;

   public SendEmail(JFrame frame) {
      super(frame, "Dialog", true);
      messageTxt = new JTextArea(T_AREA_ROWS, T_AREA_COLS);
      scroll = new JScrollPane(messageTxt);
      accountBox = new JComboBox<String>(ACCOUNT_TEXTS);

      this.setLayout(new GridBagLayout());
      int ebGap = 5;
      ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(
            ebGap, ebGap, ebGap, ebGap));

      for (int i = 0; i < LABEL_TEXTS.length; i++) {
         JLabel label = new JLabel(LABEL_TEXTS[i]);
         addLabel(0, i, label);

         if (i == 0) {
            addField(1, i, accountBox);
         } else {
            JTextField tField = new JTextField(TEXT_FIELD_LENGTH);
            fieldMap.put(LABEL_TEXTS[i], tField);
            addField(1, i, tField);
         }
      }

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = LABEL_TEXTS.length;
      gbc.gridwidth = 2;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(INSET_GAP, INSET_GAP, INSET_GAP, INSET_GAP);
      this.add(scroll, gbc);

      pack();
      this.setVisible(true);
   }

   private void addField(int x, int y, JComponent comp) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.weightx = 1.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(INSET_GAP, INSET_GAP, INSET_GAP, INSET_GAP);
      gbc.anchor = GridBagConstraints.EAST;

      this.add(comp, gbc);
   }

   private void addLabel(int x, int y, JComponent comp) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(INSET_GAP, INSET_GAP, INSET_GAP, RIGHT_INSET_GAP);
      gbc.anchor = GridBagConstraints.EAST;

      this.add(comp, gbc);
   }

   public String getTextFieldText(String key) {
      JTextField tField = fieldMap.get(key);
      if (tField == null) {
         String text = "key, " + key + " not a valid argument for fieldMap";
         throw new IllegalArgumentException(text);
      }

      return tField.getText();
   }

   public String getAccountText() {
      return accountBox.getSelectedItem().toString();
   }

   public String getMessageTxt() {
      return messageTxt.getText();
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      new SendEmail(frame);
      frame.dispose();
   }
}