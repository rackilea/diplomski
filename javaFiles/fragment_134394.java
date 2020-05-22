import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class SwapAForAleph {
   // No idea of the correct unicode for this!!!
   public static final char SINDHI_ALIF = '\u0623'; 

   public static void main(String[] args) {
      final JTextField textField = new JTextField(10);
      textField.setFont(textField.getFont().deriveFont(32f));
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
            return text.replace('a', SINDHI_ALIF);
         }
      });

      JPanel panel = new JPanel();
      panel.add(textField);
      JOptionPane.showMessageDialog(null, panel);
   }
}