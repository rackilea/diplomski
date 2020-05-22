import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class CapturePassword extends JFrame {

    private JScrollPane scroll;
    private JTextArea textArea;
    private JToggleButton expectPassword;
    private StringBuilder password; // you would of course use something else

    public CapturePassword() {
        setLayout(new BorderLayout());

        password = new StringBuilder();

        textArea = new JTextArea();
        scroll = new JScrollPane(textArea);
        add(scroll);

        expectPassword = new JToggleButton("Capture password");
        add(expectPassword, BorderLayout.PAGE_END);

        expectPassword.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (expectPassword.isSelected()) {
                    capture(true);
                } else {
                    capture(false);
                    JOptionPane.showConfirmDialog(
                            CapturePassword.this, 
                            "Captured password: " + password.toString(), 
                            "Password!", JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE);
                    password.setLength(0); // reset
                }
                textArea.requestFocusInWindow();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 400);
        setLocationRelativeTo(null);
    }

    private void capture(boolean start) {
        PlainDocument document = (PlainDocument)textArea.getDocument();
        DocumentFilter filter = new DocumentFilter() {

            private void doAppend(String text) {
                if (text.endsWith("\n")) {
                    expectPassword.doClick();
                } else {
                    password.append(text);
                }
            }

            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                // you would have to handle multi-line pastes here also
                doAppend(text);
            }

            @Override
            public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
                // cannot remove while filtering
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                doAppend(text);
            }          
        };
        document.setDocumentFilter(start ? filter : null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new CapturePassword().setVisible(true);
            }
        });
    }

}