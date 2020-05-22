import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class TestTable {

    public static void main(String[] args) {
        new TestTable();
    }

    public TestTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                MonitorTableModel model = new MonitorTableModel();
                model.setAcStatus("Off");
                model.setHeaterStatus("On");

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);                

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(scrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MonitorTableModel extends AbstractTableModel {

        private String acStatus;
        private String heaterStatus;

        public void setAcStatus(String acStatus) {
            this.acStatus = acStatus;
            fireTableCellUpdated(1, 0);
        }

        public void setHeaterStatus(String heaterStatus) {
            this.heaterStatus = heaterStatus;
            fireTableCellUpdated(1, 1);
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public String getColumnName(int column) {
            return column == 0 ? "AC Status" : "Heater Status";
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return columnIndex == 0 ? acStatus : heaterStatus;
        }

    }        
}