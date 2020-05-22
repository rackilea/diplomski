import java.awt.KeyboardFocusManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
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
            JTextField field1 = new JTextField(7);
            JTextField field2 = new JTextField(7);

            add(field1);
            add(field2);

            field1.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (e.getDocument().getLength() > 6) {
                        //field1.transferFocus();
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if (e.getDocument().getLength() > 6) {
                        //field1.transferFocus();
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                    }
                }
            });
        }

    }
}