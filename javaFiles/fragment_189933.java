class CleanResource {
   int myIndex;
   static ArrayList<ResourceImpl> all;

   void doSomething() {
     ResourceImpl impl = all.get(myIndex);
     impl.doSomething();
   } 

   protected void finalize() { ... }
}