ResultSetMetaData rsMetaData = rs.getMetaData();
int numberOfColumns = rsMetaData.getColumnCount();

// get the column names; column indexes start from 1
for (int i = 1; i < numberOfColumns + 1; i++) {
    String columnName = rsMetaData.getColumnName(i);
    // Get the name of the column's table name
    if ("theColumn".equals(columnName)) {
        System.out.println("Bingo!");
    }
}