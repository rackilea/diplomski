public static StringBuffer resultSetToStringCsv(ResultSet resultSet) throws Exception{
StringBuffer stringwriter = new StringBuffer();

ResultSet rs = resultSet;
ResultSetMetaData rsmd = rs.getMetaData();
int numberOfColumns = rsmd.getColumnCount();

//Write column names
for(int i=1;i<=numberOfColumns;i++){
 stringwriter.append(rsmd.getColumnName(i));
 stringwriter.append(',');
}
stringwriter.append('\n');
//Write rows
while(rs.next()){
 for(int i=1;i<=numberOfColumns;i++){
  try{
   stringwriter.append(""+rs.getObject(i));
  stringwriter.append(',');
  }catch (Exception e) {
   stringwriter.append("null");
 stringwriter.append(',');
}
}    
 stringwriter.append('\n');
}