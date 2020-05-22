public class MyMap {
   private Map<Class<?>, ServiceLoader<?>> loaders 
      = new HashMaps<Class<?>, ServiceLoader<?>>();

   public<T> void put(Class<T> key, ServiceLoader<T> value) {
      loaders.put(key, value);
   }

   @SuppressWarnings("unchecked")
   public<T> T get(Class<T> key) { return (ServiceLoader<T>) loaders.get(key); }
}