boolean isObjectInSet(Object object, Set<? extends Object> set) {
   boolean result = false;

   for(Object o : set) {
     if(o == object) {
       result = true;
       break;
     }
   }

   return result;
}