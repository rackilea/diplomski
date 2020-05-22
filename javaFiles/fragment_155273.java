public void refreshData() {
    DBConnect connect = new DBConnect(); 
    Object[][] data = connect.getData(); // collecting the data from DataBase after inserting, updating
    DefaultTableModel model = new DefaultTableModel(data, columnNames);  // creating a new DefaultTableModel with the new data
    table.setModel(model); // setting the DefaultTableModel to the table - Refreshing the table
}