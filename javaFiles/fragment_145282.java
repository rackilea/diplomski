public static void main(String[] args) {
   var t =new Thread("Batch Worker A"){
      @Override 
      public void run() {
         processBatch(Thread.currentThread().getName());
       }
   }.start(); 
   t.interrupt();
}