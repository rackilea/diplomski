LinkedHashMap<Integer, LinkedHashMap<String, String>> dbData = new LinkedHashMap<>();
while (rset.next()) {
    LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
    for (int col = 1; col < countCol+1; col++) {
        String colname =rset.getMetaData().getColumnName(col);
        rowData.put(colname, rset.getString(col));
    }
    int rowV = rset.getRow();
    dbData.put(rowV, rowData);
}