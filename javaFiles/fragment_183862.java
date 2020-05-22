class Shutdown {

  private Thread thread = null; 
  protected boolean flag=false;
  public Shutdown() {
     thread = new Thread("Sample thread") {
     public void run() {
        while (!flag) {
           System.out.println("Sample thread");
          try {
              Thread.currentThread().sleep(1000);
              } catch (InterruptedException ie) {
               break;
              }
        }
        System.out.println("[Sample thread] Stopped");
     }
   };
  thread.start();
  }
public void stopThread() {
    flag=true;
 }
}

class ShutdownThread extends Thread {
    private Shutdown shutdown = null;
    public ShutdownThread(Shutdown shutdown) {
      super();
      this.shutdown = shutdown;
    }
    public void run() {
         System.out.println("Shutdown thread");
         shutdown.stopThread();
         System.out.println("Shutdown completed");
    }
}

public class Main {
  public static void main(String [] args) {
   Shutdown shutdown = new Shutdown();
   try {
     Runtime.getRuntime().addShutdownHook(new ShutdownThread(shutdown));
     System.out.println("[Main thread] Shutdown hook added");
    } catch (Throwable t) {
      System.out.println("[Main thread] Could not add Shutdown hook");
    }

    try {
       Thread.currentThread().sleep(10000);
    } catch (InterruptedException ie) {}
    System.exit(0);
   }
}