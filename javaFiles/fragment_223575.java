import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/** @see http://stackoverflow.com/questions/5339702 */
public class PasswordTest {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    private static void createAndShowGui() {
        JFrame jf = new JFrame("Test Password");
        JPasswordField jpwd = new JPasswordField();
        TimedPasswordListener tpl = new TimedPasswordListener(jpwd);
        jpwd.getDocument().addDocumentListener(tpl);
        jf.add(jpwd);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.pack();
        jf.setVisible(true);
    }
}

class TimedPasswordListener implements DocumentListener, ActionListener {

    private Timer timer = new Timer(3000, this);
    private char echoChar;
    private JPasswordField pwf;

    public TimedPasswordListener(JPasswordField jp) {
        pwf = jp;
        timer.setRepeats(false);
    }

    public void insertUpdate(DocumentEvent e) {
        showText(e);
    }

    public void removeUpdate(DocumentEvent e) {
        showText(e);
    }

    public void changedUpdate(DocumentEvent e) {}

    public void showText(DocumentEvent e) {
        if (0 != pwf.getEchoChar()) {
            echoChar = pwf.getEchoChar();
        }
        pwf.setEchoChar((char) 0);
        timer.restart();
    }

    public void actionPerformed(ActionEvent e) {
        pwf.setEchoChar(echoChar);
    }
}