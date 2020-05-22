import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class TestFrame extends JFrame {

    public static void main(String... s) {
        new TestFrame();
    }

    private JTextArea area;

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void init() {
        area = new JTextArea();
        ((AbstractDocument)area.getDocument()).setDocumentFilter(getFilter(5));
        add(new JScrollPane(area));
    }

    private DocumentFilter getFilter(final int lineCount) {
        return new DocumentFilter(){

            @Override
            public void replace(FilterBypass fb, int offset, int length,
                    String text, AttributeSet attrs)
                    throws BadLocationException {
                if(area.getLineCount()<=lineCount && area.getLineOfOffset(area.getCaretPosition())<lineCount)
                        if(text.contains("\n") && area.getLineCount()<lineCount)
                            super.replace(fb, offset, length, text, attrs);
                        else if(!text.contains("\n"))
                            super.replace(fb, offset, length, text, attrs);
            }
        };
    }

}