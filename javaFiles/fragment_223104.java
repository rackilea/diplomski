Object[][] tableData = new Object[names.length][1];
for ( int i = 0; i < names.length; i++ ){
    tableData[i][0] = names[i];
}
Object[] colnames = {"MyColumnNmae"};
JTable table = new JTable(tableData, colnames);