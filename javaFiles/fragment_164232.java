try {
   tableModel = new ResultSetTableModel(driver, url, query);
} catch (SQLException ex) {
   // exception handling or JOptionPane
}
resultTable = new JTable(tableModel);