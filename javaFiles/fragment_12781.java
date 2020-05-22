import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table extends JPanel {

    JTable table;

    public Table() {
        Object[][] data = {
            {"Hello", "Hello", "Hello", "Hello", "Hello"},
            {"Hello", "Hello", "Hello", "Hello", "Hello"},
            {"Hello", "Hello", "Hello", "Hello", "Hello"},
            {"Hello", "Hello", "Hello", "Hello", "Hello"}};

        table = new JTable(new MyTableModel(data));
        add(new JScrollPane(table));

    }

    public JTable getTable() {
        return table;
    }

    class MyTableModel extends AbstractTableModel {

        private String[] columnNames = {"ID", "Title", "Author",
            "Year", "State"};
        Object[][] list;

        public MyTableModel(Object[][] list) {
            this.list = list;
        }

        @Override
        public int getRowCount() {
            return list.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return list[rowIndex][columnIndex];
        }
    }
}