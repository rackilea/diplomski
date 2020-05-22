import java.awt.ComponentOrientation;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class NonEnglishTextField {
   public static final char ALEPH = '\u05D0';

   public static void main(String[] args) {
      final JTextField textField = new JTextField(20);
      textField.setFont(textField.getFont().deriveFont(32f));
      textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      textField.setHorizontalAlignment(SwingConstants.RIGHT);
      PlainDocument doc = (PlainDocument) textField.getDocument();
      doc.setDocumentFilter(new DocumentFilter() {
         @Override
         public void insertString(FilterBypass fb, int offset, String text,
               AttributeSet attr) throws BadLocationException {
            text = filterText(text);
            super.insertString(fb, offset, text, attr);
         }

         @Override
         public void replace(FilterBypass fb, int offset, int length,
               String text, AttributeSet attrs) throws BadLocationException {
            text = filterText(text);
            super.replace(fb, offset, length, text, attrs);
         }


         private String filterText(String text) {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toLowerCase().toCharArray()) {
               if (c >= 'a' && c <= 'z') {
                  char newChar = (char) (c - 'a' + ALEPH);
                  sb.append(newChar);
               } else {
                  sb.append(c);
               }
            }
            return sb.toString();
         }
      });

      JPanel panel = new JPanel();
      panel.add(textField);
      JOptionPane.showMessageDialog(null, panel);
   }
}