import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class TestBFilter {

    public TestBFilter() {
        JTextArea field = createTextArea();
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.add(new JScrollPane(field));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JTextArea createTextArea() {
        JTextArea field = new JTextArea(10, 20);
        field.setLineWrap(true);
        field.setWrapStyleWord(true);
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr)
                    throws BadLocationException {
                if ("b".equalsIgnoreCase(str)) {
                    super.replace(fb, 0, fb.getDocument().getLength(), "", attr);
                    return;
                } else {
                    super.replace(fb, offset, length, str, attr);
                }
            }
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestBFilter();
            }
        });
    }
}