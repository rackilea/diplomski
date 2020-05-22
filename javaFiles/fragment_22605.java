ResultSet myResultSet = null;
try 
{
  try {
      myResultSet = myStatement.executeQuery(MY_QUERY);
  } catch (SQLException e) {
      throw new MySpecialException(e);
  }
  // get metadata and do stuff 
} finally 
{
  if (myResultSet != null) myResultSet.close();
}