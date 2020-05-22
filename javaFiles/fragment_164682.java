public class Executor {
  public static void runOperation(Operation operation) {
    SQLiteDatabase database = this.getWritableDatabase();
    try {
      operation.run(database);
    } catch (SQLiteException e) {
      Log.e(operation.getClass().getName(), e.getMessage());
      return false;
    } finally {
      database.close();
  }
}