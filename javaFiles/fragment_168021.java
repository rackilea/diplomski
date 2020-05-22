import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.DocumentFilter.FilterBypass;

public class MainClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame("text area test");
        JPanel panelContent = new JPanel(new BorderLayout());
        frame.setContentPane(panelContent);
        UIManager.getDefaults().put("TextArea.font", UIManager.getFont("TextField.font")); //let text area respect DPI
        panelContent.add(createSpecialTextArea(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); //center screen
        frame.setVisible(true);
    }

    private static JTextArea createSpecialTextArea() {
        final JTextArea textArea = new JTextArea("first line\nsecond line\nthird line");
        ((AbstractDocument)textArea.getDocument()).setDocumentFilter(new DocumentFilter() {

            private boolean allowChange(int offset) {
                try {
                int offsetLastLine = textArea.getLineCount() == 0 ? 0 : textArea.getLineStartOffset(textArea.getLineCount() - 1);
                return offset >= offsetLastLine;
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex); //should never happen anyway
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                if (allowChange(offset)) {
                    super.remove(fb, offset, length);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (allowChange(offset)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (allowChange(offset)) {
                    super.insertString(fb, offset, string, attr);
                }
            }



        });
        return textArea;
    }
}