public class EmailTableModel extends AbstractTableModel {
    ...
    public void addRow(Item item) {
        int rowIndex = dc.size();
        dc.add(item);
        fireTableRowsInserted(rowIndex, rowIndex);
    }
    ...
    public void deleteRow(Item item) {
        int rowIndex = dc.indexOf(item);
        if(rowIndex > -1) {
            dc.remove(item);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
    ...
}