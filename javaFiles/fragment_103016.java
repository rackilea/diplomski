class MyTable {
    private Vector columnNames = null; 
    private JTable jTable;

    public tableClass(JPanel jPanel, Vector rowDataInput, Vector columnNamesInput) {
        // ...
        jTable = new JTable(rowData, columnNames);
        // ...
    }

    public void updateTable(Vector rowDataInput) {
        model =(DefaultTableModel)jTable.getModel();

        // Now actually update the model with your new data:
        model.setDataVector(rowDataInput, columnNames);
    }
}