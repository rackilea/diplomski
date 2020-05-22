@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Employee employee = listEmployees.get(rowIndex);
    switch (columnIndex) {
        …
        case COLUMN_SUM:
            return partialSum(rowIndex);
        …
    }
}

private int partialSum(int row) {
    int viewRow = table.convertRowIndexToView(row);
    int viewCol = table.convertColumnIndexToView(COLUMN_SALARY);
    int sum = (int) table.getValueAt(viewRow, viewCol);
    for (int i = 0; i < viewRow; i++) {
        sum += (int) table.getValueAt(i, viewCol);
    }
    return sum;
}