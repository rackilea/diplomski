public class IndexAwareSet<T> implements Set {
   private Set<T> set;
   public IndexAwareSet(Set<T> set) {
     this.set = set;
   }

   // ... implement all methods from Set and delegate to the internal Set

   public int getIndex(T entry) {
     int result = 0;
     for (T entry:set) {
       if (entry.equals(value)) return result;
       result++;
     }
     return -1;
   }
 }