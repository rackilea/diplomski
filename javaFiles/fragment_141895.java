@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
   //     super.setValueAt(aValue, rowIndex, columnIndex); by default empty implementation is not necesary if direct parent is AbstractTableModel
        data[rowIndex][columnIndex] = aValue; 
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }