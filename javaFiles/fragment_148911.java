import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public class TestMuiltColumnTableSort {

    public static void main(String[] args) {
        new TestMuiltColumnTableSort();
    }
    public static final SimpleDateFormat SDF = new SimpleDateFormat("hh:mm aa");

    public TestMuiltColumnTableSort() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    MyTableModel model = new MyTableModel();
                    model.addRow("Job #1.1", "Clt A - 001", "11:34 AM");
                    model.addRow("Job #2.1", "Clt B - 001", "12:42 AM");
                    model.addRow("Job #1.1", "Clt A - 001", "01:18 PM");
                    model.addRow("Job #1.2", "Clt A - 002", "01:18 PM");
                    model.addRow("Job #3.1", "Clt C - 001", "10:30 AM");
                    model.addRow("Job #3.1", "Clt C - 001", "02:45 PM");
                    model.addRow("Job #1.2", "Clt A - 002", "12:00 PM");
                    JTable table = new JTable(model);
                    table.setAutoCreateRowSorter(false);
                    table.setDefaultRenderer(Date.class, new TimeCellRenderer());

                    TableRowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(model);
                    table.setRowSorter(sorter);

                    List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
                    sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
                    sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
                    sorter.setSortKeys(sortKeys);

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new JScrollPane(table));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (ParseException exp) {
                    exp.printStackTrace();
                    System.exit(0);
                }
            }
        });
    }

    public class TimeCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            if (value instanceof Date) {
                setText(SDF.format(value));
            }
            return this;
        }
    }

    public class MyTableModel extends AbstractTableModel {

        private List<Row> rows = new ArrayList<>(25);

        public void addRow(String name, String cat, String date) throws ParseException {

            rows.add(new Row(name, cat, SDF.parse(date)));

        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 2:
                    clazz = Date.class;
                    break;
            }
            return clazz;
        }

        @Override
        public String getColumnName(int column) {
            String name = "??";
            switch (column) {
                case 0:
                    name = "Name";
                    break;
                case 1:
                    name = "Catagory";
                    break;
                case 2:
                    name = "Date";
                    break;
            }
            return name;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Row row = rows.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = row.getName();
                    break;
                case 1:
                    value = row.getCat();
                    break;
                case 2:
                    value = row.getDate();
                    break;
            }
            return value;
        }
    }

    public class Row {

        private String name;
        private String cat;
        private Date date;

        public Row(String name, String cat, Date date) {
            this.name = name;
            this.cat = cat;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public String getCat() {
            return cat;
        }

        public Date getDate() {
            return date;
        }
    }
}