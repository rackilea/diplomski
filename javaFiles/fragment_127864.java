import java.util.concurrent.atomic.AtomicBoolean;

public class Mutex {

  public static void main(String []args){
    AtomicBoolean isLocked = new AtomicBoolean(false);
    ThreadSwap th0 = new ThreadSwap(isLocked);
    ThreadSwap th1 = new ThreadSwap(isLocked);
    ThreadSwap th2 = new ThreadSwap(isLocked);
    th0.start();
    th1.start();
    th2.start();
  }
}

class ThreadSwap extends Thread {

  private AtomicBoolean shared_IsLocked;

  public ThreadSwap(AtomicBoolean var){
    this.shared_IsLocked = var;
  }

  @Override
  public void run(){
    while(true){
      // While the flag is true (locked), keep checking
      // If it is false (not locked), atomically change its value and keep going
      while(!shared_IsLocked.compareAndSet(false, true));
      System.out.println("Thread " + getId() + " exec critical section."); 
            // Critical section
      System.out.println("Thread " + getId() + " is leaving critical section.");
      shared_IsLocked.set(false);
    }
  }
}