public TablePanel()
{
    setLayout(new BorderLayout());

    //Initializing tmodel and putting it into table
    //It's needed for "adding rows" method
    tmodel = new DefaultTableModel(data, columnNames);
    table = new JTable();

    table.setModel(tmodel);


    //Setting up JScrollPane, table Headder
    //and make scrollPane visible 
    table.setFillsViewportHeight(true);
    add(new JScrollPane(table));

}