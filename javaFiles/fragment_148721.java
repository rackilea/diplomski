try (ResultSet rs = ...) {
    DefaultTableModel model = new DefaultTableModel();
    ResultSetMetaData rsmd = rs.getMetaData();
    for (int col = 0; col < rsmd.getColumnCount(); col++) {
        model.addColumn(rsmd.getColumnName(col + 1));
    }
    model.addColumn("boolean column");

    while (rs.next()) {
        Vector data = new Vector();
        for (int col = 0; col < rsmd.getColumnCount(); col++) {
            data.add(rs.getObject(col + 1));
        }
        data.add(Boolean.FALSE);
        model.addRow(data);
    }

}