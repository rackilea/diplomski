class Demo {
   Thread t = new Thread(
                 new Runnable() {
                     public void run () {
                         //do something
                     }
                  }
    );
    Thread t1 = new Thread(
                 new Runnable() {
                     public void run () {
                         //do something
                     }
                  }
    );
    t.start(); // Line 15
    t.join();  // Line 16
    t1.start();
}