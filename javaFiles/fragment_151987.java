import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

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
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(4, 4);
                JTable table = new JTable(model);

                InputMap im = table.getInputMap();
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "CellAction");

                ActionMap am = table.getActionMap();
                am.put("CellAction", new CellAction(table));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CellAction extends AbstractAction {

        private JTable table;

        public CellAction(JTable table) {
            this.table = table;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int column = table.getSelectedColumn();
            int rowCount = table.getRowCount();
            int currentRow = table.getSelectedRow();
            if (currentRow == rowCount - 1) {
                table.editCellAt(currentRow, column);
            }
            if (column == 3 && currentRow == rowCount - 1) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Vector row = new Vector();
                row.add(null);
                row.add(null);
                row.add(null);
                row.add(null);

                model.addRow(row);
            }
            if (column == 3) {
                currentRow++;
                column = 0;
                table.setRowSelectionInterval(currentRow, currentRow);
                table.setColumnSelectionInterval(column, column);
                table.editCellAt(currentRow, column);
            }
        }

    }

}