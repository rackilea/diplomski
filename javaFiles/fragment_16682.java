import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JTableFilterDemo {

    private static TableRowSorter<TableModel> sorter;
    private Object[][] data = {{"A", 5, true, new Date()},
        {"B", 2, false, new Date()}, {"C", 4, false, new Date()},
        {"D", 8, true, new Date()}, {"E", 13, false, new Date()},
        {"F", 7, true, new Date()}, {"G", 55, false, new Date()},
        {"H", 6, false, new Date()}, {"I", 1, true, new Date()}};
    private String columnNames[] = {"Item", "Value", "Boolean", "Date"};
    private TableModel model = new DefaultTableModel(data, columnNames) {
        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 1:
                    return Integer.class;
                case 2:
                    return Boolean.class;
                case 3:
                    return Date.class;
                default:
                    return String.class;
            }
        }
    };
    private JTable table = new JTable(model);

    public JTableFilterDemo() {
        modifyDateInTable();
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        Date d1 = (Date) model.getValueAt(0, 3);
        Date d2 = (Date) model.getValueAt(model.getRowCount() - 2, 3);
        RowFilter<TableModel, Integer> low = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, d1, 3);
        RowFilter<TableModel, Integer> high = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, d2, 3);
        List<RowFilter<TableModel, Integer>> filters = Arrays.asList(low, high);
        final RowFilter<TableModel, Integer> filter = RowFilter.andFilter(filters);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Filtering Table");
        frame.add(new JButton(new AbstractAction("Toggle filter") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sorter.getRowFilter() != null) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(filter);
                }
            }
        }), BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void modifyDateInTable() {
        Date modifDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(modifDate);
        c.add(Calendar.DATE, - 1);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 0, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, +5);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 1, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, +1);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 2, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, - 16);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 3, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, +30);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 4, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, +55);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 5, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, +155);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 6, 3);
        c.setTime(modifDate);
        c.add(Calendar.DATE, -23);
        modifDate = c.getTime();
        table.setValueAt(modifDate, 7, 3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableFilterDemo jtfd = new JTableFilterDemo();
            }
        });
    }
}