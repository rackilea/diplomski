import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ClearTextAreaEg extends JPanel {
    private JTextArea textArea = new JTextArea(10, 20);

    public ClearTextAreaEg() {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        int condition = JComponent.WHEN_FOCUSED;
        InputMap inputMap = textArea.getInputMap(condition);
        ActionMap actionMap = textArea.getActionMap();

        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        inputMap.put(enterKey, enterKey.toString());
        actionMap.put(enterKey.toString(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea txtArea = (JTextArea) e.getSource();
                txtArea.setText("");
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea));
    }

    private static void createAndShowGui() {
        ClearTextAreaEg mainPanel = new ClearTextAreaEg();

        JFrame frame = new JFrame("ClearTextAreaEg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}