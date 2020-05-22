import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ProcessObserver
implements Runnable {
  protected Consumer<Process> callback;
  protected Process           toExecute;


  public ProcessObserver(
    Consumer<Process> callback, 
    Process toExecute
  ) {
    super();
    this.callback = callback;
    this.toExecute = toExecute;
  }

  @Override
  public void run() {
    while(this.toExecute.isAlive()) {
      try {
        this.toExecute.waitFor(250, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
        this.toExecute.destroyForcibly();
        return; // Honouring the interrupt request,
                // bail out here and don call the callback
      }
    }
    this.callback.accept(this.toExecute);
  }

  static public void main(String[] args) {
    ThreadPoolExecutor pool=new ThreadPoolExecutor(
        4, 1024, // the threads will mostly sleep in waitFors
        3600, TimeUnit.SECONDS, 
        new LinkedBlockingQueue<Runnable>()
    );

    Process longRunningProcess=null; // initialize it properly
    ProcessObserver observer=new ProcessObserver(
      (Process p)->System.out.println("Exit code of: "+p.exitValue()),
      longRunningProcess
    );
    pool.execute(observer);
  }
}