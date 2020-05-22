import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class JuanjoTestPanel extends JPanel {
    private static final int TA_ROWS = 25;
    private static final int TA_COLS = 60;
    private JTextArea textArea = new JTextArea(TA_ROWS, TA_COLS);
    private JTextField textField = new JTextField(30);
    private Action hacerAction = new HacerAction();

    public JuanjoTestPanel() {
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        textField.setAction(hacerAction);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("¿Que queres hacer?"));
        bottomPanel.add(Box.createHorizontalStrut(5));
        bottomPanel.add(textField);
        bottomPanel.add(new JButton(hacerAction));

        setLayout(new BorderLayout());
        add(scrollPane);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public void printToWindow(final String text) {
        if (SwingUtilities.isEventDispatchThread()) {
            textArea.append("Console:" + text + "\n");
        } else {
            SwingUtilities.invokeLater(() -> textArea.append("Console:" + text + "\n"));
        }
    }

    private class HacerAction extends AbstractAction {
        public HacerAction() {
            super("Hacer");
            putValue(MNEMONIC_KEY, KeyEvent.VK_H);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = "> " + textField.getText() + "\n";
            textArea.append(text);
            textField.selectAll();
            textField.requestFocusInWindow();
        }
    }
}