import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class TestTable {

    public static class MyModel extends AbstractTableModel {

        private List<Object[]> data;
        private List<String> columnNames;

        public MyModel(List<String> columnNames, List<Object[]> data) {
            super();
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data.get(rowIndex)[columnIndex];
        }

    }

    protected void initUI() {
        JFrame frame = new JFrame(TestTable.class.getSimpleName());
        List<String> columns = Arrays.asList("Name", "Age");
        List<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < 50; i++) {
            Object[] value = new Object[2];
            value[0] = "Name-" + i;
            value[1] = 12 + i;
            data.add(value);
        }
        JTable table = new JTable(new MyModel(columns, data));
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }
}