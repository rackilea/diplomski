import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

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

                MutableDefaultTableModel model = new MutableDefaultTableModel(4, 4);
                JTable table = new JTable(model);

                KeyStroke tabKey = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
                KeyStroke shiftTabKey = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.SHIFT_DOWN_MASK);
                KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
                KeyStroke arrowLeftKey = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
                KeyStroke arrowRightKey = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
                KeyStroke arrowDownKey = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
                KeyStroke arrowUpKey = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);

                InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
                im.put(tabKey, "nextCell");
                im.put(enterKey, "nextCell");
                im.put(arrowRightKey, "nextCell");
                im.put(shiftTabKey, "previousCell");
                im.put(arrowLeftKey, "previousCell");
                im.put(arrowDownKey, "nextRow");
                im.put(arrowUpKey, "previousRow");

                ActionMap am = table.getActionMap();
                am.put("nextCell", new NextCellAction(table, model));
                am.put("previousCell", new PreviousCellAction(table, model));
                am.put("nextRow", new NextRowAction(table, model));
                am.put("previousRow", new PreviousRowAction(table, model));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MutableDefaultTableModel extends DefaultTableModel implements MutableTableModel {

        public MutableDefaultTableModel(int rows, int cols) {
            super(rows, cols);
        }

        @Override
        public void insertNewRow(int row) {
            Object[] rowData = new Object[getColumnCount()];
            if (row < getRowCount()) {
                insertRow(row, rowData);
            } else {
                addRow(rowData);
            }
        }

    }

    public interface MutableTableModel extends TableModel {

        public void insertNewRow(int row);

    }

    public abstract class AbstractTableAction extends AbstractAction {

        private JTable table;
        private MutableTableModel model;

        private boolean forceStopEditing;

        public AbstractTableAction(JTable table, MutableTableModel model) {
            this.table = table;
            this.model = model;
        }

        public MutableTableModel getModel() {
            return model;
        }

        public JTable getTable() {
            return table;
        }

        public boolean isForceStopEditing() {
            return forceStopEditing;
        }

        public void setForceStopEditing(boolean forceStopEditing) {
            this.forceStopEditing = forceStopEditing;
        }

        public void stopCellEditing() {

            TableCellEditor editor = getTable().getCellEditor();
            if (editor != null) {

                if (!editor.stopCellEditing() && isForceStopEditing()) {

                    editor.cancelCellEditing();

                }

            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JTable table = getTable();

            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();

            int rowCount = table.getRowCount();
            int colCount = table.getColumnCount();

            stopCellEditing();

            int cell[] = updateCellCoordinates(row, col);
            row = cell[0];
            col = cell[1];

            if (col < 0) {
                col = colCount - 1;
                row--;
            } else if (col >= colCount) {
                col = 0;
                row++;
            }

            if (row < 0) {
                row = 0;
            } else if (row >= rowCount) {

                getModel().insertNewRow(row);

            }

            table.setRowSelectionInterval(row, row);
            table.setColumnSelectionInterval(col, col);

        }

        protected abstract int[] updateCellCoordinates(int row, int col);

    }

    public class NextCellAction extends AbstractTableAction {

        public NextCellAction(JTable table, MutableTableModel model) {
            super(table, model);
        }

        @Override
        protected int[] updateCellCoordinates(int row, int col) {
            return new int[]{row, ++col};
        }

    }

    public class PreviousCellAction extends AbstractTableAction {

        public PreviousCellAction(JTable table, MutableTableModel model) {
            super(table, model);
        }

        @Override
        protected int[] updateCellCoordinates(int row, int col) {
            return new int[]{row, --col};
        }

    }

    public class NextRowAction extends AbstractTableAction {

        public NextRowAction(JTable table, MutableTableModel model) {
            super(table, model);
        }

        @Override
        protected int[] updateCellCoordinates(int row, int col) {
            return new int[]{++row, col};
        }

    }

    public class PreviousRowAction extends AbstractTableAction {

        public PreviousRowAction(JTable table, MutableTableModel model) {
            super(table, model);
        }

        @Override
        protected int[] updateCellCoordinates(int row, int col) {
            return new int[]{--row, col};
        }

    }

}