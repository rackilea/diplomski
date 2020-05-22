public class DataAccess{
    private static ThreadLocal<DataAccess> THREAD_LOCAL = new ThreadLocal();
    private String databasepath;

    public DataAcess(final String databasepath) {
      this.databasepath = databasepath;
    }

    public static DataAccess getInstance() {
      return THREAD_LOCAL.get();
    }
    public static void set(final DataAccess dataAccess) {
      THREAD_LOCAL.set(dataAccess);
    }
    public static void remove() {
      THREAD_LOCAL.remove();
    }
}