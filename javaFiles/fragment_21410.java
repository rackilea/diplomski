PreparedStatement statement = conn.prepareStatement("select * from public.testDynamicReturn('stu')");

ResultSet resultSet = statement.executeQuery();

while (resultSet.next()) {
 //can give column name
 String rollNum= resultSet.getString("out_rollNum");   
  String name= resultSet.getString("out_name");   
  //will be null for 'stu'but you already know
  String gaurdian= resultSet.getString("out_gaurdian");    
}