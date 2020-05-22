// command abstract class
public static abstract class ViewScopeCacheCommand<T> { 
    public abstract T invoke();
}

// innvoker
public static class ViewScopeCache<T> {
   // cache
   private Map<String,T> pageCache = null;

   public ViewScopeCache() {
      pageCache = new HashMap<String,T>();
   }
   // get from cache
   public T get(String key) {
       return pageCache.get(key);
   }
   // put to cache
   public void put(String key, T t) {
       pageCache.put(key, t);
   }
   /*
   // I want to say how to load the result of not in cache - given by command
   public T getLazy(String key, ViewScopeCacheCommand<T> command) {
       if(get(key) == null) {
           T t = command.invoke();
           pageCache.put(key, t);
    }
    return get(key);
   }
   */
   public void invalidate() {
       pageCache.clear();
   }
   // I want to identify the cache by command
   /*** solution ***/
   public T getLazy(ViewScopeCacheCommand<T> command) {
       String magicKey = command.getClass().toString(); // <--- solution
       if(get(key) == null) {
           T t = command.invoke();
           pageCache.put(key, t);
       }
       return get(key);
   }
}