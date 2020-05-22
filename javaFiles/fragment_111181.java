public class GenericDao<T> extends BaseDao<T>  {

  private static class InstanceHolder {
      static final Map<Class<?>, GenericDao<?>> INSTANCES = new HashMap<>();
  }

  public static synchronized <T> GenericDao<T> getInstance(Class<T> clazz) {
      GenericDao<T> dao = (GenericDao<T>)InstanceHolder.INSTANCES.get(clazz);
      if (dao == null) {
        dao = new GenericDao<T>();
        InstanceHolder.INSTANCES.put(clazz, dao);
      }
      return dao;
  }

  private GenericDao() {
  }
}