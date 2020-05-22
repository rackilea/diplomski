public class DAOFactoryLoader {
  public static DAOFactory loadMySQLFactory() {
    return (DAOFactory) Class.forName("your.package.MySQLFactory").newInstance();
  }

  public static DAOFactory loadSQLiteFactory() {
    return (DAOFactory) Class.forName("your.package.SQLiteFactory").newInstance();
  }
}