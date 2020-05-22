ResultSet rs = null;    
Statement stmt = null;
Connection conn = null;
Integer myId=null;
String myVeryUniqueFileName = strFromSomeWhere;
try
{
  conn = Database.getConnection();
  stmt = conn.createStatement()
  //
  rs = stmt.executeQuery("SELECT id FROM mytable WHERE filename = '"
                         + myVeryUniqueFileName + "'");
  if (rs.next())
  {
    myId= new Integer(rs.getInt(1));
  }              
  if (rs.next())
  {
    throw new DBException("Duplicate myId: " + myId);
  }
  return myId;
} catch (Exception e) {
  // handle this
}