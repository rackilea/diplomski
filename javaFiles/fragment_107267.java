@Override
public TableCellEditor getCellEditor(int row, int column) {
    if (column == 1) {
        Object value = getValueAt(row, column);
        if (value != null)
            return getDefaultEditor(value.getClass());
    }
    return super.getCellEditor(row, column);
}