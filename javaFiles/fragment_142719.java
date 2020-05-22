public class ParentMap {
   private ConcurrentHashMap<String, Object> map1 = new ConcurrentHashMap<>();
   private ConcurrentHashMap<String, Object> map2 = new ConcurrentHashMap<>();

   public synchronized void add(Object objectToAdd) {
      // Add to map1 
      // Add to map2
   }

   public synchronized void update(String key, Object object) {
      // Update the object based on the key on both maps (following the rules of your application)
   }

   public synchronized void delete(String key) {
      // Delete in both maps following the rules of your application
   }

   public Object get(String key) {
      // Use the rules of your application to read
   }
}