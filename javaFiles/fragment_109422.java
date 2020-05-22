class Myclass {

   static private final AtomicInteger count = new AtomicInteger();
   static private final ReferenceQueue<MyClass> queue = new ReferenceQueue<MyClass>();

   {
      count.getAndIncrement();
      new PhantomReference<MyObject>(this, queue);
   }

   static public int instanceCount() { 
      return count.get();
   }

   static {
      Thread t = new Thread() {
         public void run() {
            for (;;) {
               queue.remove();
               count.decrementAndGet();
            }
         }
      };
      t.setDaemon(true);
      t.start();
   }

}