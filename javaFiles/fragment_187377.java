int rowIdx = 0;
while (rs.next()) {
    Object[] row = new Object[columns];
    // ...

    ((DefaultTableModel) table.getModel()).insertRow(rowIdx++, row);
}