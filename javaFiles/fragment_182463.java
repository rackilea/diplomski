import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Tester2 extends JPanel {
    private static final int TA_ROWS = 30;
    private static final int TA_COLS = 50;
    private JTextArea text = new JTextArea(TA_ROWS, TA_COLS);

    public Tester2() {
        text.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new ButtonAction("Press Me")));

        setLayout(new BorderLayout());
        add(scrollPane);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    private class ButtonAction extends AbstractAction {
        public ButtonAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 80; i++) {
                int wordsInSent = (int) (5 + 6 * Math.random()); 
                for (int j = 0; j < wordsInSent; j++) {
                    int wordLength = (int) (5 + 8 * Math.random());
                    for (int k = 0; k < wordLength; k++) {
                        char c = (char) ('a' + (int)(Math.random() * ('z' - 'a')));
                        sb.append(c);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
            text.append(sb.toString());
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Tester2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Tester2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}