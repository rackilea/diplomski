public class DatabaseConnectionPool {
  private static class SingletonHolder {
    public static DatabaseConnectionPool instance = new DatabaseConnectionPool(
        new MySqlStatementSupplier());
  }

  private final Supplier<Statement> statementSupplier;

  private DatabaseConnectionPool(Supplier<Statement> statementSupplier) {
    this.statementSupplier = statementSupplier;
  }

  /* Visibile for testing */
  static DatabaseConnectionPool createInstanceForTest(Supplier<Statement> s) {
    return new DatabaseConnectionPool(s);
  }

  public static DatabaseConnectionPool getInstance() {
    return SingletonHolder.instance;
  }

  // more code here
}