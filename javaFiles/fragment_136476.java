import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

@SuppressWarnings("serial")
public class ExternalsLinks2 extends JPanel {

    // constants
    private static final String[] LIST_DATA = {"Searching", "Sorting"};
    private static final Font LIST_FONT = new Font("Calibiri", Font.BOLD, 25);
    private static final Font LABEL_FONT = new Font("courier", Font.BOLD, 30);
    private static final int LIST_VISIBLE_ROW_COUNT = 10;
    private static final String TITLE_TEXT = "External Links";
    private static final Color LIST_BG = Color.CYAN;

    // JList field created with constant array data
    private JList<String> jList = new JList<>(LIST_DATA); 

    public ExternalsLinks2() {
        jList.setFont(LIST_FONT);
        jList.setPrototypeCellValue("ABCDEFGHIJKLMNOP ABCDE");
        jList.setVisibleRowCount(LIST_VISIBLE_ROW_COUNT);
        jList.setBackground(LIST_BG);

        JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
        titleLabel.setFont(LABEL_FONT);

        JButton backButton = new JButton("Back");
        // add ActionListener or AbstractAction here

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));  // use BorderLayout
        add(titleLabel, BorderLayout.PAGE_START);  // JLabel at top
        add(new JScrollPane(jList), BorderLayout.CENTER);  // JList inside of JScrollPane in center
        add(backButton, BorderLayout.PAGE_END);  // JButton at bottom
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("External Links");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ExternalsLinks2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}