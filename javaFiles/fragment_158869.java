@Override
public void setValueAt(Object aValue, int row, int column) {
    if (column == 0 && (aValue instanceof Boolean)) {
        boolean pushed = (boolean) aValue;
        if (pushed) {
            removeRow(row);
        }
    }
}