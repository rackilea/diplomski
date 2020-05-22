private void refreshTable(String query) {
    try {
            tableModel.setQuery(query);
    } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.toString(), "SQL Exception", JOptionPane.ERROR_MESSAGE);
    }
}