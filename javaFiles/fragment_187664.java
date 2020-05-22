import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.text.*;

public class TestFieldToArray {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                final JTextField field = getFilteredField();
                final JTextField field2 = getFilteredField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(field);
                panel.add(field2);
                JOptionPane.showMessageDialog(null, panel);
            }
        }); 
    }

    static JTextField getFilteredField() {
        JTextField field = new JTextField(15);
        AbstractDocument doc = (AbstractDocument) field.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {

            private final int maxChars = 8;

            @Override
            public void replace(FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {
                int docLength = fb.getDocument().getLength();
                if (docLength < maxChars) {
                super.replace(fb, offs, length,
                        str.replaceAll("[^0-9]+", ""), a);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {
                int docLength = fb.getDocument().getLength();
                if (docLength < maxChars) {
                    super.insertString(fb, offs,
                            str.replaceAll("[^0-9]+", ""), a);
                }        
            }
        });
        return field;
    }
}