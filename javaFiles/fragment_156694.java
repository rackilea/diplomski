@ThreadSafe
public class DBAccessServiceFactory {
  private static class ResourceHolder {
    public static DBAccessService INSTANCE = new DBAccessService();
  }
  public static DBAccessService getResource() {
    return ResourceHolder.INSTANCE;
  }
}