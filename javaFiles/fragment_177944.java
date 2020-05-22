DefaultTableModel model = new DefaultTableModel(columnNames, 0);

while (resultSet.next()) {
    String data1 = resultSet.getString(1);
    String data2 = resultSet.getString(2);
    ...
    Object[] rowData = new Object[] { data1, data2, ... };
    model.addRow(rowData);
}

return model;