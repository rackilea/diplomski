Thread thread1 = new Thread() {
   public void run() {
      x = aMethod(args...);
   }
};

Thread thread2 = new Thread() {
   public void run() {
     x += aMethod(args...);
   }
};

thread1.start();
thread2.start();