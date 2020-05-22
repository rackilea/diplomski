class MyObject {
   private AtomicInteger worksInProgress = new AtomicInteger(0);
   public int incWIP() {
      return worksInProgress.incrementAndGet();
   }
   public int decWIP() {
      return worksInProgress.decrementAndGet();
   }
   public int getWIP() {
      return worksInProgress.get();
   }
   ...
}

MyObject getObject(String name) {
   synchronized(map) {
      MyObject obj = map.get(name);
      if (obj == null) {
         obj = new MyObject();
         map.put(name, obj);
      }
      obj.incWIP(); // assume you're doing work on this starting now
   }
}