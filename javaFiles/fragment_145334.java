public Object getValueAt(int rowIndex, int columnIndex) {
    if (columnIndex==5 || columnIndex==7) {
    return Boolean.valueOf((String) data.elementAt((rowIndex * getColumnCount())
            + columnIndex));
    }
    return (String) data.elementAt((rowIndex * getColumnCount())
            + columnIndex);

}