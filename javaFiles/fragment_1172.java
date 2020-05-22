public class DatabaseConnection {

  private static DatabaseConnection instance; //note this is static

  private DatabaseConnection() { //note this is private
  }

  public static DatabaseConnection getInstance() { //note this is static
    if (instance == null) {
      instance = new DatabaseConnection();
    }
    return instance;
  }