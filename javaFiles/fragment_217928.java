private void setParameters(PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException
{
  for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
  {
    preparedStatement.setObject(i, resultSet.getObject(i)); 
  }  
}