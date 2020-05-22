ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
ResultSetMetaData rsmd = rs.getMetaData();
Integer colunNum = rsmd.getColumnCount();
for(int i =0; i < columnNum; i ++){
    String colmnName = rsmd.getColumnName(i);
    ....
}