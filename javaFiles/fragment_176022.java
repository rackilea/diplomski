import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Example extends JFrame {

    JTextField textbox = new JTextField(" ", 20);

    public Example() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,
                AttributeSet attr) throws BadLocationException {
                super.insertString(fb, offset, string, attr);
                System.out.println("Inserted!");
            }

            public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
                throws BadLocationException {
                super.remove(fb, offset, length);
                System.out.println("removed!");
            }

            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                AttributeSet attrs) throws BadLocationException {
                super.replace(fb, offset, length, text, attrs);
                System.out.println("replaced!");
            }
        };

        ((AbstractDocument) textbox.getDocument()).setDocumentFilter(filter);
        panel.add(textbox);
        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}