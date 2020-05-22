public interface ResultSetHandler<ResultType> {
     ResultType handleResultSet(ResultSet rs);
}

public <ResultType> ResultType getTransformedResults(String query, ResultSetHandler<ResultType> rsh) throws SQLException {      
  Connection connection = null;
  Statement stmt = null;

  try { 
    connection = dataSource.getConnection();
    stmt = connection.createStatement();
    ResultSet rs = stmtm.executeQuery(query);
    return rsh.handleResultSet(rs);
  } catch (SQLException sqle) {
    // cleanup 
    throw sqle;
  } finally {
    if(stmt != null) {
      statement.close(); // closes also resultSet
      connection.close();
    }
  }
}