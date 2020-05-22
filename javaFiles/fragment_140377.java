String query = "insert into ....";
PreparedStatement pstmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
int rowsAffected = pstmt.executeUpdate();
int newId = -1;
ResultSet rs = pstmt.getGeneratedKeys();
if (rs.next()) 
{
  newId = rs.getInt(1);
}
rs.close();
pstmt.close();