import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableSelection {

    public TableSelection() {
        JTabbedPane tabPane = createTabPane();

        JFrame frame = new JFrame("Frame");
        frame.setContentPane(tabPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private JTabbedPane createTabPane() {
        JTabbedPane pane = new JTabbedPane();
        JTable table = createTable(pane);
        pane.add(new JScrollPane(table), "Table Tab");
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        pane.add(panel1, "Other Panel");
        return pane;
    }

    private JTable createTable(final JTabbedPane tabs) {
        String[][] data = {{"HELLO", "WORLD"}, {"HELLO", "WORLD"}};
        String[] cols = {"Hello", "World"};
        JTable table = new JTable(data, cols);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    tabs.setSelectedIndex(tabs.indexOfTab("Other Panel"));
                }
            }
        });

        return table;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableSelection();
            }
        });
    }
}