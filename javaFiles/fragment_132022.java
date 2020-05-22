import java.awt.BorderLayout;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class TestDocumentFilter {

    public static void main(String... args) {
        new TestDocumentFilter();
    }

    public TestDocumentFilter() {
        JTextField textField = new JTextField(10);
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new CustomDocumentFilter());

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(5, 5));
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private class CustomDocumentFilter extends DocumentFilter {

        private Pattern regexCheck = Pattern.compile("[0-9]+");

        @Override
        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }

            if (regexCheck.matcher(str).matches()) {
                super.insertString(fb, offs, str, a);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
                throws BadLocationException {
            if (str == null) {
                return;
            }

            if (regexCheck.matcher(str).matches()) {
                fb.replace(offset, length, str, attrs);
            }
        }
    }
}