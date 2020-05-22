import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            int maxCharacters = 8;
            AutoFocusTransferListener listener = new AutoFocusTransferListener() {
                @Override
                public void focusTransferShouldOccur(Document doc) {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                }
            };
            AutoFocusTransferDelegate delegate = new MaxLengthAutoFocusTransferDelegate(maxCharacters);
            DocumentFilter filter = new SizeFilter(maxCharacters);
            DocumentListener docListener = new AutoFocusTransferHandler(listener, delegate);

            add(createTextField(8, filter, docListener), gbc);
            add(createTextField(8, filter, docListener), gbc);
            add(new JButton("Ok"), gbc);
        }

        protected  JTextField createTextField(int maxCharacters, DocumentFilter filter, DocumentListener docListener) {
            JTextField field = new JTextField(maxCharacters);
            AbstractDocument doc = (AbstractDocument)field.getDocument();
            doc.setDocumentFilter(filter);
            doc.addDocumentListener(docListener);
            return field;
        }

    }

    public class MaxLengthAutoFocusTransferDelegate implements AutoFocusTransferDelegate {

        private int maxLength;

        public MaxLengthAutoFocusTransferDelegate(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public boolean shouldTransferFocus(Document doc) {
            return doc.getLength() >= maxLength;
        }

    }

    public class SizeFilter extends DocumentFilter {

        private int maxCharacters;

        public SizeFilter(int maxChars) {
            maxCharacters = maxChars;
        }

        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
                throws BadLocationException {

            if ((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
                super.insertString(fb, offs, str, a);
            }
        }

        public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
                throws BadLocationException {

            if ((fb.getDocument().getLength() + str.length() - length) <= maxCharacters) {
                super.replace(fb, offs, length, str, a);
            }
        }
    }

    public class AutoFocusTransferHandler implements DocumentListener {

        private AutoFocusTransferListener listener;
        private AutoFocusTransferDelegate delegate;

        public AutoFocusTransferHandler(AutoFocusTransferListener listener, AutoFocusTransferDelegate delegate) {
            this.listener = listener;
            this.delegate = delegate;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            checkForTransfer(e.getDocument());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkForTransfer(e.getDocument());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkForTransfer(e.getDocument());
        }

        public void checkForTransfer(Document doc) {
            if (delegate != null && delegate.shouldTransferFocus(doc)) {
                if (listener != null) {
                    listener.focusTransferShouldOccur(doc);
                }
            }
        }

    }

    public interface AutoFocusTransferDelegate {

        public boolean shouldTransferFocus(Document doc);
    }

    public interface AutoFocusTransferListener {

        public void focusTransferShouldOccur(Document doc);
    }
}