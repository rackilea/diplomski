import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/** @see https://stackoverflow.com/a/17415635/230513 */
public class TestTableLoad01 {

    public static void main(String[] args) {
        new TestTableLoad01();
    }

    public TestTableLoad01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final MyTableModel model = new MyTableModel();
                JTable table = new JTable(model);
                table.setDefaultRenderer(Date.class, new TimeCellRenderer());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.add(new JButton(new AbstractAction("Go") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TableSwingWorker worker = new TableSwingWorker(model);
                        worker.execute();
                    }
                }), BorderLayout.SOUTH);
            }
        });
    }

    public class TimeCellRenderer extends DefaultTableCellRenderer {

        private DateFormat df;

        public TimeCellRenderer() {
            df = new SimpleDateFormat("HH:mm:ss");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            if (value instanceof Date) {

                value = df.format(value);

            }

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            return this;

        }
    }

    public class MyTableModel extends AbstractTableModel {

        private String[] columnNames = new String[]{"Date", "Row"};
        private List<RowData> data;

        public MyTableModel() {
            data = new ArrayList<RowData>(25);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 0 ? Date.class : Integer.class;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public Object getValueAt(int row, int col) {
            RowData value = data.get(row);
            return col == 0 ? value.getDate() : value.getRow();
        }

        public void addRow(RowData value) {
            int rowCount = getRowCount();
            data.add(value);
            fireTableRowsInserted(rowCount, rowCount);
        }

        public void addRows(RowData... value) {
            addRows(Arrays.asList(value));
        }

        private void addRows(List<RowData> rows) {
            int rowCount = getRowCount();
            data.addAll(rows);
            fireTableRowsInserted(rowCount, getRowCount() - 1);
        }
    }

    public class RowData {

        private Date date;
        private int row;

        public RowData(int row) {
            this.date = new Date();
            this.row = row;
        }

        public Date getDate() {
            return date;
        }

        public int getRow() {
            return row;
        }
    }

    public class TableSwingWorker extends SwingWorker<MyTableModel, RowData> {

        private final MyTableModel tableModel;

        public TableSwingWorker(MyTableModel tableModel) {
            this.tableModel = tableModel;
        }

        @Override
        protected MyTableModel doInBackground() throws Exception {

            // This is a deliberate pause to allow the UI time to render
            Thread.sleep(1000);

            System.out.println("Start polulating");

            for (int index = 0; index < 1000000; index++) {

                RowData data = new RowData(index);
                publish(data);
                Thread.yield();
            }
            return tableModel;
        }

        @Override
        protected void process(List<RowData> chunks) {
            System.out.println("Adding " + chunks.size() + " rows");
            tableModel.addRows(chunks);
        }
    }
}