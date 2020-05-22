public void addRow(Object[] dates) {
    data.add(dates);
    int row = data.indexOf(dates);
    for(int column = 0; column < dates.length; column++) {
        fireTableCellUpdated(row, column);
    }
    fireTableRowsInserted(row, row);
}