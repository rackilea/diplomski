ArrayList<String> inner; 
ResultSet rs = statement.executeQuery(sqlQuery);
ResultSetMetaData rsmd = rs.getMetaData();

while (rs.next()) {
    inner = new ArrayList<String>(); 
    for(int i=1; i<=columnsNumber; i++){
       inner.add(rs.getString(i));
    }    
    outer.add(inner);               
}