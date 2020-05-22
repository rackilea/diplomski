import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class AreaAsLabel extends JPanel {
    private JTextArea textEntry = new JTextArea(5, 20);
    private JTextArea labelLikeDisplay = new JTextArea(5, 20);

    public AreaAsLabel() {
        textEntry.setLineWrap(true);
        textEntry.setWrapStyleWord(true);

        labelLikeDisplay.setLineWrap(true);
        labelLikeDisplay.setWrapStyleWord(true);
        labelLikeDisplay.setEditable(false);
        labelLikeDisplay.setFocusable(false);
        labelLikeDisplay.setOpaque(false);

        add(new JScrollPane(textEntry));
        add(new JButton(new TransferTextAction("Transfer Text")));
        add(labelLikeDisplay);
    }

    class TransferTextAction extends AbstractAction {
        public TransferTextAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textEntry.getText();
            labelLikeDisplay.setText(text);

            textEntry.selectAll();
            textEntry.requestFocusInWindow();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("AreaAsLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AreaAsLabel());
        frame.pack();
        frame.setLocationRelativeTo(null);
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