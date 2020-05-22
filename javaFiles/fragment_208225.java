public class SynchronizedExample{

  private final Object LOCK = new Object();

  public void doSomethingOr() {
    if(somethingIsNotDone()) {
      synchronize(LOCK) {
        LOCK.wait(); //trycatch here
      }
    }
  }

  public void somethingSone() {
   somethingIsDone = true;
   synchronized(LOCK) {
     LOCK.notifyAll(); //trycatch
   }
  }
}