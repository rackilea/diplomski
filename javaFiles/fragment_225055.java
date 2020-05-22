import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class TestTable04 {

    public static void main(String[] args) {
        new TestTable04();
    }

    private int id = 0;

    public TestTable04() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                final RecordTableModel model = new RecordTableModel();
                JTable table = new JTable(model);

                JButton add = new JButton("Add");
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.add(new Record(++id));
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(add, BorderLayout.SOUTH);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class Record {

        private int id;
        private String value;

        public Record(int id) {
            this.id = id;
        }

        public int getID() {
            return id;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public class RecordTableModel extends AbstractTableModel {

        private List<Record> lstRecords;

        public RecordTableModel() {
            lstRecords = new ArrayList<>(24);
        }

        public void add(Record record) {
            lstRecords.add(record);
            fireTableRowsInserted(lstRecords.size() - 1, lstRecords.size() - 1);
        }

        public void remove(Record record) {
            if (lstRecords.contains(record)) {
                int index = lstRecords.indexOf(record);
                remove(index);
            }
        }

        public void remove(int index) {
            lstRecords.remove(index);
            fireTableRowsDeleted(index, index);
        }

        @Override
        public int getRowCount() {
            return lstRecords.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 0:
                    clazz = Integer.class;
                    break;
            }
            return clazz;
        }

        @Override
        public String getColumnName(int column) {
            String name = null;
            switch (column) {
                case 0:
                    name = "ID";
                    break;
                case 1:
                    name = "Value";
                    break;
            }
            return name;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Record record = lstRecords.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = record.getID();
                    break;
                case 1:
                    value = record.getValue();
                    break;
            }
            return value;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Record record = lstRecords.get(rowIndex);
            switch (columnIndex) {
                case 1:
                    record.setValue(aValue == null ? null : aValue.toString());
                    fireTableCellUpdated(rowIndex, columnIndex);
                    break;
            }
        }
    }
}