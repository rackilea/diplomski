import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTabbedPane {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JFrame f = new JFrame();
    private String[] columnNames = {"First Name", "Last Name", "Sport",
        "# of Years", "Vegetarian"};
    private Object[][] data = {
        {"Kathy", "Smith", "Snowboarding", new Integer(5), (false)},
        {"John", "Doe", "Rowing", new Integer(3), (true)},
        {"Sue", "Black", "Knitting", new Integer(2), (false)},
        {"Jane", "White", "Speed reading", new Integer(20), (true)},
        {"Joe", "Brown", "Pool", new Integer(10), (false)}
    };
    private DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        private static final long serialVersionUID = 1L;

        @Override
        public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };

    public MyTabbedPane() {
        tabbedPane.addTab("Tab1", new JScrollPane(new JTable(model)));
        tabbedPane.addTab("Tab2", new JScrollPane(new JTable(model)));
        tabbedPane.addTab("Tab3", new JScrollPane(new JTable(model)));
        tabbedPane.addTab("Tab4", new JScrollPane(new JTable(model)));
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(tabbedPane, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyTabbedPane frame = new MyTabbedPane();    
            }
        });
    }
}