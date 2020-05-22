@Override
public void setValueAt(Object value, int row, int col) {
    MyObject obj = list.get(row);
    if (col == 4) {
        obj.isVeg = (Boolean)value;
    }
    fireTableCellUpdated(row, col);
}