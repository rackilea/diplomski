public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    if (columnIndex == 5) {
        if ("Delete".equals(aValue)) {
            removeRow(rowIndex);
        }
    }
}