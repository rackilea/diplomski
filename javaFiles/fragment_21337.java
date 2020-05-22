import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class TallyTableTest {

    public static void main(String[] args) {
        new TallyTableTest();
    }

    public TallyTableTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    final MyTableModel model = new MyTableModel();
                    loadData(model);
                    JTable table = new JTable(model);

                    JButton update = new JButton("Update");
                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (int row = 0; row < model.getRowCount(); row++) {
                                int counter = 0;
                                for (int col = 3; col < 7; col++) {
                                    Object value = model.getValueAt(row, col);
                                    if (value instanceof Boolean && (boolean)value) {
                                        counter++;
                                    }
                                }
                                model.setValueAt(counter, row, 7);
                            }
                        }
                    });

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new JScrollPane(table));
                    frame.add(update, BorderLayout.SOUTH);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);


                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });

    }

    public void loadData(MyTableModel model) throws IOException {
        // Fill your model here
    }

    public static class MyTableModel extends AbstractTableModel {

        protected static final String[] COLUMNS = new String[]{
            "ID", "First Name", "Last Name", "1", "2", "3", "4", "total"
        };
        protected static final Class[] COLUMN_TYPES = new Class[]{
            Integer.class, String.class, String.class,
            Boolean.class, Boolean.class, Boolean.class, Boolean.class,
            Integer.class
        };
        private List<Object[]> rows;

        public MyTableModel() {
            rows = new ArrayList<>(25);
        }

        public void addRow(Object[] data) {
            rows.add(data);
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES[columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object[] row = rows.get(rowIndex);
            return row[columnIndex];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Object[] row = rows.get(rowIndex);
            row[columnIndex] = aValue;
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex >= 3 && columnIndex <= 6;
        }
    }

}