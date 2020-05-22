DBConnection db = new DBConnection();
try (ResultSet rs = DBConnection.stmt.executeQuery("SELECT ID, MESSAGE FROM STOCK WHERE ID = '" + id + "'")) {

    if (stockTableModel == null) {
        stockTableModel = new DefaultTableModel();
        for (int col = 0; col < metaData.getColumnCount(); col++) {
            stockTableModel.addColumn(metaData.getColumnName(col + 1));
        }
        jTable.setModel(model);
    }

    while (rs.next()) {
        Vector rowData = new Vector(metaData.getColumnCount());
        for (int col = 0; col < metaData.getColumnCount(); col++) {
            rowData.add(rs.getObject(col + 1));
        }
        stockTableModel.addRow(rowData);
    }

} catch (SQLException exp) {
    exp.printStackTrace();
}