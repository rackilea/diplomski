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
        // Because I'm hacking a little, I've included the source table...
        JTable table = (JTable) source;
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
            JTable table = (JTable) comp;
            // Need the location where the drop might occur
            DropLocation dl = support.getDropLocation();
            Point dp = dl.getDropPoint();
            // Get the column at the drop point
            int dragColumn = table.columnAtPoint(dp);
            try {
                // Get the Transferable, we need to check
                // the constraints
                Transferable t = support.getTransferable();
                CellData cd = (CellData) t.getTransferData(CellDataTransferable.CELL_DATA_FLAVOR);
                // Make sure we're not dropping onto ourselves...
                if (cd.getTable() != table) {
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
                CellData cd = (CellData) t.getTransferData(CellDataTransferable.CELL_DATA_FLAVOR);
                if (cd.getTable() != target) {
                    // Make sure the columns match
                    if (dropCol == cd.getColumn()) {
                        // Get the data from the "dropped" table
                        String exportValue = (String) target.getValueAt(dropRow, dropCol);
                        // Get the data from the "dragged" table
                        String importValue = cd.getValue();
                        // This is where we swap the values...
                        // Set the target/dropped tables value
                        target.setValueAt(importValue, dropRow, dropCol);

                        // Set the source/dragged tables values
                        JTable source = cd.getTable();
                        int row = source.getSelectedRow();
                        int col = source.getSelectedColumn();
                        source.setValueAt(exportValue, row, col);

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