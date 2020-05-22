class Myclass {

   static private final AtomicInteger count = new AtomicInteger();

   {
      count.getAndIncrement();
   }

   static public int instanceCount() { 
      return count.get();
   }

   // edit: account for serializable
   private void readObject(ObjectInputStream ois) 
       throws ClassNotFoundException, IOException {
      counter.getAndIncrement();
      ois.defaultReadObject();          
   }
}