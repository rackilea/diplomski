ExecutorService service = ...
for(int i=0;i<1000*1000;i++) {
   final int finalI = i;
   service.submit(new Runnable() {
      public void run() {
         System.out.println("Task "+finalI+" run.");
      }
   });
}