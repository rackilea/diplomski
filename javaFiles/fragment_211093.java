public void run() {
      for(int i=0;i<=5;i++) {
   // 3 is too darn small. and yield() is not necessary
   // so let me just iterate 6 times now to improve performance.  
     System.out.println(i+Thread.currentThread().toString());

   }