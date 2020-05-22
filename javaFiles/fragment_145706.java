class Chef implments Runnable {

  private Object lock;
  Chef(Object lock) {
     this.lock = lock;
  }

  public run() {

      synchronized(lock) {
         // do stuff here
      }
  }

}


class Waiter implments Runnable {

  private Object lock;
  Chef(Object lock) {
     this.lock = lock;
  }

  public run() {

      synchronized(lock) {
         // do stuff here
      }
  }

}


//your main

 public static void main(String []args) {
    Object obj = new Object();
    Thread chef = new Thread(new Chef(obj));
    Thread waiter = new Thread(new Waiter(obj));
    chef.start();
    waiter.start();
 }