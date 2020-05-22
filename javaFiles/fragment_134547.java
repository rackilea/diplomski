public class JdbcSQLServerDriverUrlExample
{
  public static void main(String[] args)
  {
    Connection connection = null;
    try
    {
      // the sql server driver string
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      // the sql server url
      String url = "jdbc:microsoft:sqlserver://HOST:1433;DatabaseName=DATABASE";

      // get the sql server database connection
      connection = DriverManager.getConnection(url,"THE_USER", "THE_PASSWORD");

      // now do whatever you want to do with the connection
      // ...

    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      System.exit(2);
    }
  }
}