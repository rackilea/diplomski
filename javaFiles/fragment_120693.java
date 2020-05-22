class MyTableModel extends AbstractTableModel {
    ...
    public void addRow(Object newRow) {
        // add row to underlying data structure here
         fireTableRowsInserted(rowIndex, rowIndex);
    }

    public void remove(Object rowToBeDeleted) {
        // remove row from the underlying data structure here
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    ...
}