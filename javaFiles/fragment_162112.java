ArrayList<ArrayList<CellValue>> cells = new ArrayList<>();

ResultSetMetaData rsmd = resTablesData1.getMetaData();
int colCount = rsmd.getColumnCount();

while(resTablesData1.next()) {
    ArrayList<CellValue> row = new ArrayList<>();
    for (int k=0; k<colCount ; k++) {
        String colName = rsmd.getColumnName(i);
        Object o = resTablesData1.getObject(colName);
        row.add(new CellValue(rsmd.getColumnType(),o.toString());
    }
    cells.add(row);
}