import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TestTable {
    public JFrame myUI = new JFrame();
    private JTabbedPane tabbedPane = new JTabbedPane();

    public TestTable() {
        makeTabbedPane();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestTable();
            }
        });
    }

    private void makeTabbedPane() {

        JPanel tabs = new JPanel();
        String tabsName = "tags";

        Object columnNames[] = {"id", "name"};
        Object rowData[][] = {
            {"1", "Jean"},
            {"2", "Annie"}
        };
        DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
        JTable tagsTable = new JTable(model);
        tagsTable.setRowHeight(24);
        JTableHeader header = tagsTable.getTableHeader();
        header.setFont(new Font("", Font.BOLD, 20));
        JScrollPane jsp = new JScrollPane(tagsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        tabs.setLayout(new BorderLayout());
        //tabs.add(header, BorderLayout.NORTH);
        tabs.add(jsp, BorderLayout.CENTER);
        tabs.add(new JButton("OK"), BorderLayout.SOUTH);

        tabbedPane.addTab(tabsName, tabs);
        myUI.add(tabbedPane);
        myUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myUI.pack();
        myUI.setLocationRelativeTo(null);
        myUI.setVisible(true);
    }
}