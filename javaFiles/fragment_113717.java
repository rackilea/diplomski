public static int getIndex(Set<? extends Object> set, Object value) {
   int result = 0;
   for (Object entry:set) {
     if (entry.equals(value)) return result;
     result++;
   }
   return -1;
 }