public static void main(String[] args) {

     Runnable r = new Runnable() {
         public void run() {
             runYourBackgroundTaskHere();
         }
     };

     ExecutorService executor = Executors.newCachedThreadPool();
     executor.submit(r);
     //this line will execute immediately, not waiting for your task to complete
}