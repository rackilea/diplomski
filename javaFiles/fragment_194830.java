import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class DocListenerFoo extends JPanel {
    private JTextField nameTextField = new JTextField(20);

    public DocListenerFoo() {
        add(new JLabel("Add Text:"));
        add(nameTextField);

        int timerDelay = 1000; // one second
        nameTextField.getDocument().addDocumentListener(new MyDocListener(timerDelay));
    }

    private class MyDocListener implements DocumentListener {
        private Timer docTimer;
        private int timerDelay;

        public MyDocListener(int timerDelay) {
            this.timerDelay = timerDelay;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            textChangedAction(e);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            textChangedAction(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            textChangedAction(e);
        }

        private void textChangedAction(DocumentEvent e) {
            Document doc = e.getDocument();
            try {
                String text = doc.getText(0, doc.getLength());
                if (docTimer != null && docTimer.isRunning()) {
                    docTimer.stop();
                }

                docTimer = new Timer(timerDelay, new TimerListener(text));
                docTimer.setRepeats(false);
                docTimer.start();
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }

    }

    private class TimerListener implements ActionListener {

        private String text;

        public TimerListener(String text) {
            this.text = text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO do check on text here 
            System.out.println("Checking text here: " + text);
        }

    }

    private static void createAndShowGui() {
        DocListenerFoo mainPanel = new DocListenerFoo();

        JFrame frame = new JFrame("DocListenerFoo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}