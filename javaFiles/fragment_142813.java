import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextLabelMirror {

    private JPanel mainPanel = new JPanel();
    private JTextField field = new JTextField(20);
    private JTextField field1 = new JTextField(20);

    public TextLabelMirror() {
        field.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            private void updateLabel(DocumentEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        field1.setText(field.getText());
                    }
                });
            }
        });

        mainPanel.setLayout(new GridLayout(1, 0, 10, 0));
        mainPanel.add(field);
        mainPanel.add(field1);
    }

    public JComponent getComponent() {
        return mainPanel;
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("TextLabelMirror");
        frame.getContentPane().add(new TextLabelMirror().getComponent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}