import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class TwoTextAreas extends JPanel {
    // our nonsense String
    public static final String LoremIpsum = "Lorem ipsum dolor sit amet, "
            + "consectetur adipiscing elit, sed do eiusmod tempor incididunt "
            + "ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
            + "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea "
            + "commodo consequat. Duis aute irure dolor in reprehenderit in "
            + "voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
            + "Excepteur sint occaecat cupidatat non proident, sunt in culpa "
            + "qui officia deserunt mollit anim id est laborum.";
    private static final int ROWS = 30;
    private static final int COLS = 40;
    private static final Dimension TA_PREF_SIZE = new Dimension(440, 480);
    private JTextArea colRowTextArea = new JTextArea(ROWS, COLS);
    private JTextArea prefSizeTextArea = new JTextArea();

    public TwoTextAreas() {
        setLayout(new GridLayout(1, 0));
        prefSizeTextArea.setPreferredSize(TA_PREF_SIZE);

        add(setUpTextArea(colRowTextArea, "Set Columns & Rows"));
        add(setUpTextArea(prefSizeTextArea, "Set Preferred Size"));

    }

    private JPanel setUpTextArea(JTextArea textArea, String title) {
        // allow word wrapping
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AppendTextAction(textArea)));

        JPanel holderPanel = new JPanel(new BorderLayout());
        holderPanel.setBorder(BorderFactory.createTitledBorder(title));
        holderPanel.add(scrollPane);
        holderPanel.add(buttonPanel, BorderLayout.PAGE_END);
        return holderPanel;
    }

    private class AppendTextAction extends AbstractAction {
        private JTextArea textArea;
        private StringBuilder sb = new StringBuilder();

        public AppendTextAction(JTextArea textArea) {
            super("Append Text to TextArea");
            this.textArea = textArea;

            // create nonsense String
            for (int i = 0; i < 100; i++) {
                sb.append(LoremIpsum);
                sb.append("\n");
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append(sb.toString());
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Two TextAreas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TwoTextAreas());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}