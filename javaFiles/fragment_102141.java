import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class JTableExample {
    public static void main(String[] args) {
        JPanel borderLayoutPanel = new JPanel(new BorderLayout());
        String[] headers = {"Header 1", "Header 2", "etc..."};
        String[][] data = {{"Some data", "some more data", "etc..."},
                {"Some data 1", "some more data 3", "etc..."},
                {"Some data 2", "some more data 4", "etc..."}};

        JTable table = new JTable(data, headers);
        JScrollPane scrollableTable = new JScrollPane(table);
        borderLayoutPanel.add(scrollableTable, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(borderLayoutPanel);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}