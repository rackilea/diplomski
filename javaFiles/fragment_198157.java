//creating a table
    MyTableModel mod = new MyTableModel(data, columnNames);
    JTable table = new JTable(mod);
    table.setVisible(true);
    table.getColumnClass(1); // will return the data type class of first column
    table.isCellEditable(1, 0);