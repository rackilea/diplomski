import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FilterDemo {

    public FilterDemo() {
        JFrame frame = new JFrame();
        frame.add(createFilteredField());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    private  JTextField createFilteredField() {
        JTextField field = new JTextField(10);
        AbstractDocument document = (AbstractDocument) field.getDocument();
        document.setDocumentFilter(new DocumentFilter() {

            @Override
            public void replace(FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());

                StringBuilder builder = new StringBuilder(text);
                builder.insert(offs, str);
                String newText = builder.toString();

                // check
                System.out.println("text = " + text 
                               + ", offset = " + offs 
                               + ", newText = " + newText);

                if (newText.matches("(-)?\\d*")) {
                    super.replace(fb, offs, length, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }


            @Override
            public void insertString(FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());

                StringBuilder builder = new StringBuilder(text);
                builder.insert(offs, str);
                String newText = builder.toString();

                // checks
                System.out.println("text = " + text 
                               + ", offset = " + offs 
                               + ", newText = " + newText);

                if (newText.matches("(-)?\\d*")) {
                    super.insertString(fb, offs, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            } 
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FilterDemo();
            }
        });
    }
}