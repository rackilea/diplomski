public class DataAccess{
    private static ThreadLocal<DataAccess> THREAD_LOCAL = new ThreadLocal() {
     @Override
     protected DataAccess initialValue() {
             return new DataAccess();
     }
    };
    private String databasepath;

    public static DataAccess getInstance() {
      return THREAD_LOCAL.get();
    }
}