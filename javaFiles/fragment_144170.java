class EvenOddThread {
  public static void main (String [] args) {
  Runnable runnEven = new ThreadPrint (10);

  Thread t1 = new Thread (runnEven);
  Thread t2 = new Thread (runnEven);

  t1.start ();
  t2.start ();

  }
}

class ThreadPrint implements Runnable {
  private int maxPoint = 0;
  private int counter = 0;
  ThreadPrint (int max) {
    maxPoint = max;
  }

  @Override
  public void run () {
    while (counter <= maxPoint) {
      synchronized(this) {
        if (counter % 2 == 0) {

          System.out.println("By Thread" + Thread.currentThread().getName() +" :: "+ counter);
          counter ++;
          notify();
          try {
            wait();
          }
          catch (Exception e) {
            System.out.println(e);
          }
        }
        else if (counter % 2 != 0){
          System.out.println("By Thread" + Thread.currentThread().getName() +" :: "+ counter);
          counter ++;
          notify();
          try {
            wait();
          }
          catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    }
  }
}