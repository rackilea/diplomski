import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChatClient2 extends JPanel {
    private static final int VISIBLE_ROW_COUNT = 30;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> chatList = new JList<>(listModel);
    private SendAction sendAction = new SendAction("Send");
    private JTextField textField = new JTextField(20);
    private JButton sendButton = new JButton(sendAction);

    public ChatClient2() {
        chatList.setFocusable(false);
        chatList.setVisibleRowCount(VISIBLE_ROW_COUNT);
        JScrollPane scrollPane = new JScrollPane(chatList);

        textField.setAction(sendAction);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(textField);
        bottomPanel.add(sendButton);

        setLayout(new BorderLayout());
        add(scrollPane);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class SendAction extends AbstractAction {
        public SendAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            listModel.add(0, text);
            textField.selectAll();
            textField.requestFocusInWindow();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Chat Client2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChatClient2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}