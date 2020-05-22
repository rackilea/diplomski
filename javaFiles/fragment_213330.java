import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Gsb3 extends JPanel {
    private static final int WORD_FIELD_COUNT = 10;
    private static final int COL_SIZE = 10;
    private static final int TA_ROWS = 40;
    private static final int TA_COLS = 40;
    private JTextField[] wordFields = new JTextField[WORD_FIELD_COUNT];
    private int rows;
    private JTextArea stuffArea = new JTextArea(TA_ROWS, TA_COLS);

    public Gsb3() {
        JPanel wordFieldsPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < wordFields.length; i++) {
            wordFields[i] = new JTextField(COL_SIZE);
            wordFieldsPanel.add(wordFields[i]);
        }

        JPanel wrapWordFieldsPanel = new JPanel(new GridBagLayout());
        wrapWordFieldsPanel.add(wordFieldsPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
        buttonPanel.add(new JButton(new MyAction("Restart", KeyEvent.VK_R)));
        buttonPanel.add(new JButton(new MyAction("Exit", KeyEvent.VK_X)));
        buttonPanel.add(new JButton(new MyAction("BONANZA!", KeyEvent.VK_B)));
        buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(stuffArea);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(wrapWordFieldsPanel);
        add(Box.createHorizontalStrut(5));
        add(buttonPanel);
        add(Box.createHorizontalStrut(5));
        add(scrollPane);

    }

    private class MyAction extends AbstractAction {
        public MyAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO add code

        }
    }

    private static void createAndShowGui() {
        Gsb3 mainPanel = new Gsb3();

        JFrame frame = new JFrame("Gsb2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}