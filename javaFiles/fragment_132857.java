int godine = Integer.parseInt(inputAge.getText());
String sqlStmt = "select * from person where age =  ?";
prepStmt = conn.prepareStatement(sqlStmt);
prepStmt.setInt(1, godine);
ResultSet rs = prepStmt.executeQuery();
rs.close(); 
prepStmt.close();