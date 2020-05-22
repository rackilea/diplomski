public void setValueAt(Object ob, int row, int column) throws SQLException {
    resultSet.absolute(r+1);
    if (ob == null) {
        resultSet.updateNull(column+2);
    } else {
        resultSet.updateObject(column+2,ob);
    }
    rs.updateRow();
    this.fireTableCellUpdated(row,column);  
}
public boolean isCellEditable(int row, int col) {
    return true;
}