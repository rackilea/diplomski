import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.MOVE;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TableSwap {

    public static void main(String[] args) {
        new TableSwap();
    }

    public TableSwap() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable t1 = createTable(0);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(t1));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected JTable createTable(int startAt) {

        DefaultTableModel model = new DefaultTableModel(0, 2);
        for (int index = 0; index < 10; index++) {
            model.addRow(new Object[]{"0x" + (index + startAt), "1x" + (index + startAt)});
        }

        JTable table = new JTable(model);
        table.setDragEnabled(true);
        table.setDropMode(DropMode.USE_SELECTION);
        table.setTransferHandler(new TransferHelper());
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);

        return table;
    }

    public class CellData {

        private final Object value;
        private final int col;
        private final JTable table;
        private final int row;

        public CellData(JTable source) {
            this.col = source.getSelectedColumn();
            this.row = source.getSelectedRow();
            this.value = source.getValueAt(row, col);
            this.table = source;
        }

        public int getColumn() {
            return col;
        }

        public Object getValue() {
            return value;
        }

        public JTable getTable() {
            return table;
        }

        public boolean swapValuesWith(int targetRow, int targetCol) {

            boolean swapped = false;

            if (targetCol == col) {

                Object exportValue = table.getValueAt(targetRow, targetCol);
                table.setValueAt(value, targetRow, targetCol);
                table.setValueAt(exportValue, row, col);
                swapped = true;

            }

            return swapped;

        }

    }

    public static final DataFlavor CELL_DATA_FLAVOR = createConstant(CellData.class, "application/x-java-celldata");

    public class CellDataTransferable implements Transferable {

        private CellData cellData;

        public CellDataTransferable(CellData cellData) {
            this.cellData = cellData;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{CELL_DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            boolean supported = false;
            for (DataFlavor available : getTransferDataFlavors()) {
                if (available.equals(flavor)) {
                    supported = true;
                }
            }
            return supported;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            return cellData;
        }

    }

    static protected DataFlavor createConstant(Class clazz, String name) {
        try {
            return new DataFlavor(clazz, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public class TransferHelper extends TransferHandler {

        private static final long serialVersionUID = 1L;

        public TransferHelper() {
        }

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent source) {
            // Create the transferable
            JTable table = (JTable) source;
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();
            Object value = table.getValueAt(row, col);
            return new CellDataTransferable(new CellData(table));
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
        }

        @Override
        public boolean canImport(TransferSupport support) {
            // Reject the import by default...
            boolean canImport = false;
            // Can only import into another JTable
            Component comp = support.getComponent();
            if (comp instanceof JTable) {
                JTable target = (JTable) comp;
                // Need the location where the drop might occur
                DropLocation dl = support.getDropLocation();
                Point dp = dl.getDropPoint();
                // Get the column at the drop point
                int dragColumn = target.columnAtPoint(dp);
                try {
                    // Get the Transferable, we need to check
                    // the constraints
                    Transferable t = support.getTransferable();
                    CellData cd = (CellData) t.getTransferData(CELL_DATA_FLAVOR);
                    // Make sure we're not dropping onto ourselves...
                    if (cd.getTable() == target) {
                        // Do the columns match...?
                        if (dragColumn == cd.getColumn()) {
                            canImport = true;
                        }
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
            }
            return canImport;
        }

        @Override
        public boolean importData(TransferSupport support) {
            // Import failed for some reason...
            boolean imported = false;
            // Only import into JTables...
            Component comp = support.getComponent();
            if (comp instanceof JTable) {
                JTable target = (JTable) comp;
                // Need to know where we are importing to...
                DropLocation dl = support.getDropLocation();
                Point dp = dl.getDropPoint();
                int dropCol = target.columnAtPoint(dp);
                int dropRow = target.rowAtPoint(dp);
                try {
                    // Get the Transferable at the heart of it all
                    Transferable t = support.getTransferable();
                    CellData cd = (CellData) t.getTransferData(CELL_DATA_FLAVOR);
                    if (cd.getTable() == target) {
                        if (cd.swapValuesWith(dropRow, dropCol)) {
                            imported = true;
                        }
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }

            }
            return imported;
        }
    }

}