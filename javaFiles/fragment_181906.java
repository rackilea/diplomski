/* Method to return values in a column of JTable as an array */

public Object[] columnToArray(JTable table, int columnIndex){
    // get the row count
    int rowCount = table.getModel().getRowCount();
    // declare the array
    Object [] data = new Object[rowCount];
    // fetch the data
    for(int i = 0; i < rowCount; i++){
        data[i] = table.getModel().getValueAt(i, columnIndex);        
    }
    return(data);
}