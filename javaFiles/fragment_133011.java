public class DatabaseHelper {
    public static final BasicDataSource dataSource = new BasicDataSource();

    static {
       setDataSourceParameter();
    }

    public static void setDataSourceParameter() {
       try {
        dataSource.setDriverClassName(H2_DB_DRIVER);
        dataSource.setUrl(H2_DB_CONNECTION);
        dataSource.setUsername(H2_DB_USER);
        dataSource.setPassword(H2_DB_PASSWORD);
        dataSource.setValidationQuery("SELECT 1");
        LOGGER.log(Level.DEBUG, "setDataSourceParameter()");
    } catch (Exception e) {
        LOGGER.log(Level.ERROR, e.getMessage(), e.fillInStackTrace());
     }
 } 

 /**
  * This method returns a database connection used for database query
  *
  * @return Connection
  */
 public static Connection getDBConnection() throws SQLException {
     LOGGER.log(Level.DEBUG, "getDBConnection() : getNumActive : " + dataSource.getNumActive());
     LOGGER.log(Level.DEBUG, "getDBConnection() : getNumIdle : " +       dataSource.getNumIdle());
     return dataSource.getConnection();
 }

 /**
  * This method closes database related resources
  *
  * @param connection
  * @param statement
  * @param resultSet
  */
  public static void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
     try {
         if (statement != null) {
             statement.close();
         }
         if (resultSet != null) {
             resultSet.close();
         }
         if (connection != null) {
             connection.close();
          }
      }  catch (SQLException e) {
         LOGGER.log(Level.ERROR, e.getMessage(), e.fillInStackTrace());
     }
  }
}

public static boolean validate(String username, String password) {
    Connection dbConnection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    try {
        dbConnection = getDBConnection();
        if (dbConnection == null) {
            return false;
        }

        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + USERS_USERNAME + " = ? AND " + USERS_PASSWORD
                + " = ?";
        LOGGER.log(Level.TRACE, "validate() : query " + query);
        preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    } catch (Exception e) {
        LOGGER.log(Level.ERROR, e.getMessage(), e.fillInStackTrace());
        return false;
    } finally {
        closeResources(dbConnection, preparedStatement, resultSet);
    }
}