import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;    
import javax.swing.*;

@SuppressWarnings("serial")
public class Chat2 extends JPanel {
    private static final int ROWS = 25; // rows in the chat view JTextArea
    private static final int COLS = 40; // columns in the chat view JTextArea
                                        // and text entry area
    private static final int ENTRY_ROWS = 4; // rows in the text entry JTextArea
    private static final int BL_HGAP = 10; // horizontal gap for our
                                           // BorderLayout
    private static final int BL_VGAP = 5; // vertical gap for our BorderLayout
    private static final int EB_GAP = 15; // gap for empty border that goes
                                          // around entire app
    private static final String TITLE_TEXT = "My Chat Application";
    private static final float TITLE_POINTS = 32f; // size of the title jlabel
                                                   // text
    private JTextArea chatViewArea = new JTextArea(ROWS, COLS);
    private JTextArea textEntryArea = new JTextArea(ENTRY_ROWS, COLS);

    public Chat2() {
        // label to display the title in bold large text
        JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_POINTS));

        // set up the chat view JTextArea to have word wrap
        // and to not be focusable
        chatViewArea.setWrapStyleWord(true);
        chatViewArea.setLineWrap(true);
        chatViewArea.setFocusable(false);

        // add it to a JScrollPane, and give the scrollpane vertical scrollbars
        JScrollPane viewScrollPane = new JScrollPane(chatViewArea);
        viewScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // set up the text entry JTextArea
        textEntryArea.setWrapStyleWord(true);
        textEntryArea.setLineWrap(true);

        // key bindings so that control-enter will act as enter and the enter key will "submit"
        // the user input to the chat window and the chat server
        // will allow us to use a multilined text entry area if desired instead
        // of a single lined JTextField
        setEnterKeyBinding(textEntryArea);

        JScrollPane entryScrollPane = new JScrollPane(textEntryArea);
        entryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // add an empty border around entire application
        setBorder(BorderFactory.createEmptyBorder(EB_GAP, EB_GAP, EB_GAP, EB_GAP));
        // make the main layout a BorderLayout
        setLayout(new BorderLayout(BL_HGAP, BL_VGAP));
        // add our components to the GUI
        add(titleLabel, BorderLayout.PAGE_START);
        add(viewScrollPane, BorderLayout.CENTER);
        add(entryScrollPane, BorderLayout.PAGE_END);
    }

    // Again, use key bindings so that control-enter JTextArea will act as enter key
    // and the enter key will "submit" the user input to the chat window and the chat server.
    // When ctrl-enter is pushed the Action originally bound to the enter key will be called
    // and when enter is pushed a new Action, the EnterKeyAction, will be called
    private void setEnterKeyBinding(JTextArea textArea) {
        int condition = JComponent.WHEN_FOCUSED; // only for focused entry key
        InputMap inputMap = textArea.getInputMap(condition);
        ActionMap actionMap = textArea.getActionMap();

        KeyStroke entryKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        KeyStroke ctrlEntryKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        // first give ctrl-enter the action held by enter
        Object entryKey = inputMap.get(entryKeyStroke);
        Action entryAction = actionMap.get(entryKey);
        inputMap.put(ctrlEntryKeyStroke, ctrlEntryKeyStroke.toString());
        actionMap.put(ctrlEntryKeyStroke.toString(), entryAction);

        // now give enter key a new Action
        EnterKeyAction enterKeyAction = new EnterKeyAction();
        inputMap.put(entryKeyStroke, entryKeyStroke.toString());
        actionMap.put(entryKeyStroke.toString(), enterKeyAction);
    }

    public void appendToChatArea(final String text) {
        if (SwingUtilities.isEventDispatchThread()) {
            chatViewArea.append(text + "\n");
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    chatViewArea.append(text + "\n");
                }
            });
        }
    }

    private class EnterKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textEntryArea.getText();
            textEntryArea.setText("");

            chatViewArea.append("User: " + text + "\n");

            // TODO send text to the chat server!

        }
    }

    private static void createAndShowGui() {
        Chat2 mainPanel = new Chat2();

        JFrame frame = new JFrame("My Chat Window");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);

        // pack the JFrame so that it will size itself to its components
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