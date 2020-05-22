import java.awt.Component;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Test4 {

    private static class ComboBoxCellRenderer extends JComboBox implements TableCellRenderer {

        public ComboBoxCellRenderer(int column) {
            for (int i = 0; i < 10; i++) {
                addItem("Cell (" + i + "," + column + ")");
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setSelectedItem(value);
            return this;
        }
    }

    protected void initUI() {
        JFrame frame = new JFrame("test");
        frame.add(getTable());
        frame.pack();
        frame.setVisible(true);
    }

    private Component getTable() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (int i = 0; i < 10; i++) {
            Vector<String> row = new Vector<String>();
            for (int j = 0; j < 3; j++) {
                row.add("Cell (" + i + "," + j + ")");
            }
            data.add(row);
        }
        Vector<String> columns = new Vector<String>();
        columns.add("Column 1");
        columns.add("Column 2");
        columns.add("Column 3");
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setRowHeight(20);
        int i = 0;
        Enumeration<TableColumn> c = table.getColumnModel().getColumns();
        while (c.hasMoreElements()) {
            TableColumn column = c.nextElement();
            column.setCellRenderer(new ComboBoxCellRenderer(i));
            i++;
        }
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test4().initUI();
            }
        });
    }
}