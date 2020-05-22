DatabaseMetaData md = connection.getMetaData();  
String query = "";
boolean exist=false  

ResultSet rs = md.getTables(null, null, "table_name", null);

while (rs.next()) {
  exist = True ;
}  

if(!exist){
       query="CREATE TABLE table_name ...";
       connection.createStatement().executeUpdate(query);
}