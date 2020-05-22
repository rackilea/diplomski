addRunnable(
   ()->{
       some code;
       callMethodThrowsException();  // this throws e.g. IOException
   },

   ()->{
       other code;
   }
   // ... and possibly more Runnables here
);