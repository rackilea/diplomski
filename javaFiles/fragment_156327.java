// a TransferHandler for dragging a column between tables
// by changing its visiblity property
public class TableColumnTransferHandler extends TransferHandler {
    private final DataFlavor localObjectFlavor = new ActivationDataFlavor(
            Integer.class, DataFlavor.javaJVMLocalObjectMimeType,
            "Integer Column Model Index");


    @Override
    protected Transferable createTransferable(JComponent c) {
        JXTable table = (JXTable) c;
        int index = table.getSelectedColumn();
        TableColumnExt column = table.getColumnExt(index);
        return new DataHandler(column.getModelIndex(),
                localObjectFlavor.getMimeType());
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport info) {
        return info.isDataFlavorSupported(localObjectFlavor);
    }

    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.MOVE;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        JXTable target = (JXTable) info.getComponent();
        JTable.DropLocation dl = (JTable.DropLocation) info.getDropLocation();
        try {
            Integer columnFrom = (Integer) info.getTransferable().getTransferData(
                    localObjectFlavor);
            TableColumnExt tableColumn = null;
            List<TableColumn> columns = target.getColumns(true);
            for (TableColumn column : columns) {
                if (column.getModelIndex() == columnFrom) {
                    ((TableColumnExt) column).setVisible(true);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

// its usage
JXTable source = new JXTable(new AncientSwingTeam());
JXTable printable = new JXTable(source.getModel());
TransferHandler handler = new TableColumnTransferHandler();
List<TableColumn> columns = printable.getColumns();
for (TableColumn tableColumn : columns) {
    ((TableColumnExt) tableColumn).setVisible(false);
}
source.setTransferHandler(handler);
source.setDragEnabled(true);
printable.setTransferHandler(handler);
printable.setDragEnabled(true);