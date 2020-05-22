threads[i] = new Thread() {
   @Override public void run() {
     doSomeWork();
   }
};
threads[i].start();