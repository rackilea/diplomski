public  Map<Integer, Map<String, Object>> retrieveRecord(String sql, Object[] inputs) {

Map<Integer, Map<String, Object>> mapOfResults = new HashMap<Integer, Map<String, Object>>();

 SqlRowSet rset;
 if (inputs.length == 0) {
    rset = getJdbcTemplate().queryForRowSet(sql);
 } else {
    rset = getJdbcTemplate().queryForRowSet(sql, inputs);
 }
 int colCount = rset.getMetaData().getColumnCount();
 int rowIndex = 1;
 while (rset.next()) {

    Map<String, Object> columnValueMap = new HashMap<String, Object>();
    for (int i = 1; i <= colCount; i++) {
        columnValueMap.put(rset.getMetaData().getColumnLabel(i), rset.getObject(i));
    }

    mapOfResults.put(rowIndex, columnValueMap); //now you can access valueMap using index.
    rowIndex++;
 }
    return mapOfResults;
}