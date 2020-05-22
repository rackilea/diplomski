import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class ValidateTextField {

    public ValidateTextField() {
        JFrame frame = new JFrame();
        JTextField field = createTextField();
        frame.setLayout(new GridBagLayout());
        frame.add(field);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JTextField createTextField() {
        final JTextField field = new JTextField(15);
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                int length = field.getDocument().getLength();
                if (length + str.length() <= 7) {
                    fb.insertString(off, str.replaceAll("[^0-9a-zA-Z]", ""), attr);  // remove non-digits
                }
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                int length = field.getDocument().getLength();
                if (length + str.length() <= 7) {
                    fb.replace(off, len, str.replaceAll("[^0-9a-zA-Z]", ""), attr);  // remove non-digits
                }
            }
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ValidateTextField();
            }
        });
    }
}