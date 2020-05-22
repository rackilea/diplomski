ResultSetMetaData    rsmd    =    resultSet.getMetaData();
int    columnCount    =    rsmd.getColumnCount();
// The column count starts from 1
for    (int    i=1;   i<=columnCount;    i++ ) {
  String name    =    rsmd.getColumnName(i);
  // Do stuff with name
}