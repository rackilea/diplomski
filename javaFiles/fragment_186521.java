import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JListExample extends JPanel {
    public JListExample() {
        String[] listData = { "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five", "One", "Two", "Three", "Four", "Five", "One", "Two", "Three",
                "Four", "Five" };
        JList<String> myList = new JList<>(listData);

        myList.setVisibleRowCount(10);
        myList.setPrototypeCellValue("abcdefghijklm");
        JScrollPane scrollPane = new JScrollPane(myList);
        add(scrollPane);

    }

    private static void createAndShowGui() {
        JListExample mainPanel = new JListExample();

        JFrame frame = new JFrame("E.G.");
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