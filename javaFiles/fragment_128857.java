private void createTablesForBuilding() {
    int buildingcoutns = 5;

    for (int i = 0; i < buildingcoutns; i++) {
        myTables tbls = new myTables();
        tbls.setTableID(i);

        tables.add(tbls);

        JTable thistable = tables.get(i).table;

        thistable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        tables.get(i).table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (thistable.getSelectedRow() > -1) {
                    System.out.println("tableID is:"+tbls.getTableID());
                }
            }
        });

        Buildings_Panel.add(tables.get(i));
    }
}