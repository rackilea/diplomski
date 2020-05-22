public NewJFrame() {
    initComponents();
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Type");
    tableModel.addColumn("Folder");
    String[] row = {"Datum1","Datum2"};
    tableModel.addRow(row);
    jTable1.setModel(tableModel);// where jTable1 has been created and instantiated automatically by netbeans when you draged and dropt it to your frame , from the design.
}