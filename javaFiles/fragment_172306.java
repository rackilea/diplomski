tableModel = new DefaultTableModel(rowData, columnNames);
    table = new JTable(tableModel);
    int columnCount = table.getColumnModel().getColumnCount(); //get number of columns
    //for each column apply the custom rendered
    for (int i = 0; i < columnCount; i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(new CustomRenderer());
    }