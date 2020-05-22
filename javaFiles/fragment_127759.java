threads[i] = new Thread(new Runnable() {
   @Override public void run() {
     doSomeWork();
   }
});
threads[i].start();