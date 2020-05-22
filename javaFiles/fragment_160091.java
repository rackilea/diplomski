private void fillTable(final JTable table, final List biens) {
    final String columnNames[] = {"Column A", "Column B", "Column C"};
    final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    table.setModel(tableModel);
    for (final Object bien : biens) {
        // Assuming each row in the biens list is a list of strings...
        final List<String> row = (List<String>) bien;
        tableModel.addRow(row.toArray());
    }
}