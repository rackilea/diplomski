DefaultTableModel model = new DefaultTableModel(columnNames, 0);

while (resultSet.next()) {
    Vector<String> row = new Vector<>();
    for (int i = 1; i <= numberOfCols; i++) {
        row.add(resultSet.getString(i));
    }
    model.addRow(row);
}

return model;