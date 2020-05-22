import java.awt.GridLayout;
import javax.swing.*;

public class JListExample extends JPanel {
    private JList<String> list1 = new JList<>();
    private JList<String> list2 = new JList<>();

    public JListExample() {
        list1.setVisibleRowCount(20);
        list2.setVisibleRowCount(20);
        list1.setPrototypeCellValue(String.format("%60s", ""));
        list2.setPrototypeCellValue(String.format("%60s", ""));

        setLayout(new GridLayout(1, 2));
        add(new JScrollPane(list1));
        add(new JScrollPane(list2));
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