ResultSetMetaData rsMeta = resultSet.getMetaData();
int numberOfCols = rsMeta.getColumnCount();
Vector<String> columnNames = new Vector<>();   // your columns names
for (int i = 1; i <= numberOfCols; i++ ){
    columnsNames.add(rsMeta.getColumnName(i));
}