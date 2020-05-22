void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    //depending on your data structure add the aValue object to the specified
    //rowIndex and columnIndex position in your data object
    //notify the JTable object:
    fireTableCellUpdated(row, col);
}