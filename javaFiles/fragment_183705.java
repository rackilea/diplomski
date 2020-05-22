class LazyObjectInitialization {

   private Collection<String> items; 

   public final Iterator<String> items() {

      if(items == null || items.isEmpty()) {
         return Collections.emptyIterator(); 
      }

      return items.iterator();
   }

   public final add(String item) { 

      if(items == null) {
         items = new ArrayList<>();
      }

      items.add(item);
   }
}