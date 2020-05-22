Connection sourceConnection = null; 
Connection destinationConnection = null; 

PreparedStatement selectStatement = null;
PreparedStatement insertStatement = null;

ResultSet resultSet = null;

try
{
  sourceConnection = ...
  destinationConnection = ...

  selectStatement = sourceConnection.prepareStatement("SELECT * FROM table");
  resultSet = selectStatement.executeQuery();

  insertStatement = destinationConnection.prepareStatement(createInsertSql(resultSet.getMetaData()));

  int batchSize = 0;
  while (resultSet.next())
  {
    setParameters(insertStatement, resultSet);
    insertStatement.addBatch();
    batchSize++;

    if (batchSize >= BATCH_EXECUTE_SIZE)
    {
      insertStatement.executeBatch();
      batchSize = 0;  
    }
  }

  insertStatement.executeBatch();
}
finally 
{
  JdbcUtils.closeResultSet(resultSet);

  JdbcUtils.closeStatement(insertStatement);
  JdbcUtils.closeStatement(selectStatement);

  JdbcUtils.closeConnection(destinationConnection);
  JdbcUtils.closeConnection(sourceConnection);
}