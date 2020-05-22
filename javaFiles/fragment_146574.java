ResultSet rs = ...
ResultSetMetaData md = rs.getMetaData();
int columnCount = md.getColumnCount();

String[] cols = new String[columnCount];
for (int i = 1; i <= columnCount; i++) {
    col[i - 1] = md.getColumnName(i);
}

DefaultTableModel model = new DefaultTableModel(cols, 0);

while(rs.next()) {
    Object[] row = new Object[columnCount];
    for (int i = 1; i <= columnCount; i++) {
        row[i - 1] = rs.getObject(i);
    }
    model.addRow(row);
}

table.setModel(model);