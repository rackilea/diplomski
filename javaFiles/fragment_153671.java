import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class JListExample extends JPanel {
    private static final int LIST_ROW_COUNT = 20;
    private static final int LIST_CHAR_WIDTH = 80;
    private static final String LIST_PROTOTYPE = "%" + LIST_CHAR_WIDTH + "s";
    private JList<String> list1 = new JList<>();
    private JList<String> list2 = new JList<>();

    public JListExample() {
        list1.setVisibleRowCount(LIST_ROW_COUNT);
        list2.setVisibleRowCount(LIST_ROW_COUNT);
        list1.setPrototypeCellValue(String.format(LIST_PROTOTYPE, ""));
        list2.setPrototypeCellValue(String.format(LIST_PROTOTYPE, ""));

        setLayout(new GridLayout(1, 2));
        add(createListWrapper(list1, "JList 1"));
        add(createListWrapper(list2, "JList 2"));
    }

    private JComponent createListWrapper(JList<String> list, String title) {
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(scrollPane);
        wrapperPanel.setBorder(BorderFactory.createTitledBorder(title));
        return wrapperPanel;
    }

    private static void createAndShowGui() {
        JListExample mainPanel = new JListExample();

        JFrame frame = new JFrame("JList Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
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