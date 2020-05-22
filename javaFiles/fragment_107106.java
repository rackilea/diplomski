import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class HeaderDoubleclickTest {

    private String[] columnNames = {"String", "Integer", "Boolean"};
    private Object[][] data = {
        {"aaa", 12, true}, {"bbb", 5, false},
        {"CCC", 92, true}, {"DDD", 0, false}
    };
    private TableModel model = new DefaultTableModel(data, columnNames) {

        private static final long serialVersionUID = 1L;

        @Override
        public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    private JTable table = new JTable(model);
    private JTableHeader header;

    static class TestTableRowSorter extends TableRowSorter<TableModel> {

        TestTableRowSorter(TableModel m) {
            super(m);
        }

        @Override
        public void toggleSortOrder(int column) {
        }

        public void wrapToggleSortOrder(int column) {
            super.toggleSortOrder(column);
        }
    }
    private Timer timer = new Timer(400, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("single");
            JTable table = header.getTable();
            RowSorter sorter;
            if (pt != null && table != null && (sorter = table.getRowSorter()) != null) {
                int columnIndex = header.columnAtPoint(pt);
                if (columnIndex != -1) {
                    columnIndex = table.convertColumnIndexToModel(columnIndex);
                    ((TestTableRowSorter) sorter).wrapToggleSortOrder(columnIndex);
                }
            }
        }
    });
    private Point pt;

    public JComponent makeUI() {
        timer.setRepeats(false);
        table.setRowSorter(new TestTableRowSorter(model));
        header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(final MouseEvent e) {
                if (timer.isRunning() && !e.isConsumed() && e.getClickCount() > 1) {
                    System.out.println("double");
                    pt = null;
                    timer.stop();
                } else {
                    pt = e.getPoint();
                    timer.restart();
                }
            }
        });
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(table));
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(new HeaderDoubleclickTest().makeUI());
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}