private void initSearchTable() {
    final String[] colNames = {"Sl.no.", "File Name", "Size", "Last Modified", "PO", "LN", "SI", "MS", "PT"};
    //PO: Part Order
    //LN: Line Number
    //SI: Serial Number
    //MS: Material Supplier
    //PT: Part Item 
    final String[][] emptyData = {
        {"", "", "", "", "", "", "", "", "",},
        {"", "", "", "", "", "", "", "", "",},
        {"", "", "", "", "", "", "", "", "",},
        {"", "", "", "", "", "", "", "", "",},
        {"", "", "", "", "", "", "", "", "",},};
    table_3.setModel(new DefaultTableModel(emptyData, colNames));
    //frmViperManufacturingRecord.getContentPane().add(table_3); <-- NB this should be commented out!!
    table_3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table_3.getColumnModel().getColumn(0).setPreferredWidth(40);
    table_3.getColumnModel().getColumn(1).setPreferredWidth(290);
    table_3.getColumnModel().getColumn(2).setPreferredWidth(80);
    table_3.getColumnModel().getColumn(3).setPreferredWidth(178);
    table_3.getColumnModel().getColumn(4).setPreferredWidth(25);
    table_3.getColumnModel().getColumn(5).setPreferredWidth(25);
    table_3.getColumnModel().getColumn(6).setPreferredWidth(25);
    table_3.getColumnModel().getColumn(7).setPreferredWidth(25);
    table_3.getColumnModel().getColumn(8).setPreferredWidth(25);
    JScrollPane scrollPane = new JScrollPane(table_3);
    scrollPane.setBounds(324, 209, 713, 160);
    frmViperManufacturingRecord.getContentPane().add(scrollPane);
}