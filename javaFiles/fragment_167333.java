table.setDropTarget(new DropTarget() {

    @Override
    public synchronized void drop(DropTargetDropEvent dtde) {
        try {
            // get row to put new item in
            int row = table.rowAtPoint(dtde.getLocation());
            // inserting row:
            ((DefaultTableModel) table.getModel()).insertRow(
                    //if the row wasn't found, add it to the end of the JTable
                    row == -1 ? table.getRowCount() : row,
                    // pass string flavor of transferable data as row data parameter
                    new Object[] {dtde.getTransferable()
                                .getTransferData(DataFlavor.stringFlavor)});
        } catch(UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }
});