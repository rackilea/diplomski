public TableSorterDemo() { 
    super(new GridLayout(1,0)); 
    TableSorter sorter = new TableSorter(new MyTableModel()); //ADDED THIS 
    //JTable table = new JTable(new MyTableModel());          //OLD 
    JTable table = new JTable(sorter);             //NEW 
    sorter.addMouseListenerToHeaderInTable(table); //ADDED THIS 
    ...
}