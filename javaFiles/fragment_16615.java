String insert = "insert into logTbl (log) values(?)";
PreparedStatement pstmt = connection.prepareStatement(insert,  Statement.RETURN_GENERATED_KEYS);
pstmt.executeUpdate();
ResultSet rs = pstmt.getGeneratedKeys();
long id = -1;
while (rs.next()) 
{
   rs.getLong(1);
}