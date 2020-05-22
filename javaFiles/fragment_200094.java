int columnCount = resultSetMetaData.getColumnCount();
System.out.println("Total Columns: "+columnCount);
for(int index = 1; index <= columnCount; index++){
    System.out.print("Column Name: "+resultSetMetaData.getColumnName(index));
    System.out.println("Table Name: "+resultSetMetaData.getTableName(index));
}