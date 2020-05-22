public class DatabaseConnection {
  private static final DatabaseConnection instance = new DatabaseConnection();

  // Private constructor prevents instantiation from other classes
  private DatabaseConnection() { }

  public static DatabaseConnection getInstance() {
    return instance;
  }
}