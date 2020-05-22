@Override
public void setValueAt(Object value, int row, int col) {
    if (value instanceof String) {
        String[] temp = data.get(row);
        temp[col] = value.toString();

        data.set(row, temp);
        fireTableRowsUpdated(row, row);
    }
}