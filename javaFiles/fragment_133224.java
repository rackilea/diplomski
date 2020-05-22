DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
    singleclick.setClickCountToStart(1);

    //set the editor as default on every column
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.setDefaultEditor(table.getColumnClass(i), singleclick);
    }