//placeholder for id variable
String sqlStr = "select * from Employee where ID = ?";
//retrieve the connection to database
Connection con = ...;
//prepare the statement from the connection
PreparedStatement pstmt = con.prepareStatement(sqlStr);
//pass the id as parameter to the prepared statement
pstmt.setInt(id);
//execute the statement
ResultSet rs = pstmt.execute();