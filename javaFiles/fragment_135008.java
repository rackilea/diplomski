import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class MyWindow extends JPanel {

    private static final int ROWS = 10, COLS = 50;

    private final JTextArea outputTextArea;

    public MyWindow() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JTextArea inputTextArea = new JTextArea(ROWS, COLS);
        inputTextArea.getDocument().addDocumentListener(new TransliterateDocumentListener());
        add(putInTitledScrollPane(inputTextArea,"Input"));

        outputTextArea = new JTextArea(ROWS, COLS);
        outputTextArea.setFocusable(false);
        outputTextArea.setEditable(false);

        add(putInTitledScrollPane(outputTextArea, "Output"));
    }


    private JPanel putInTitledScrollPane(JComponent component, String title) {
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createTitledBorder(title));
        wrapperPanel.add(new JScrollPane(component));
        return wrapperPanel;
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Document Listener Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add( new MyWindow());
        frame.pack();
        frame.setVisible(true);
    }


    private void insert(String text, int from) {
        text = process(text);
         try {
            outputTextArea.getDocument().insertString(from, text, null);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private void remove(int from, int length) {
         try {
            outputTextArea.getDocument().remove(from, length);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private String process(String text) {
        //todo process text as needed
        //returns upper case text for demo
        return text.toUpperCase();
    }

    class TransliterateDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            Document doc = e.getDocument();
            int from = e.getOffset(), length = e.getLength();
            try {
                insert(doc.getText(from, length), from);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            remove(e.getOffset(), e.getLength());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
             //Plain text components don't fire these events.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}