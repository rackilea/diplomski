@Service("MyThreadManagerService")
public class MyThreadManagerServiceImpl implements MyThreadManagerService {
  private Thread[] workers;
  private int workerPoolSize = 5;

  /**
   * This gets ran after any constructors and setters, but before anything else
   */
  @PostConstruct
  private void init() {
    workers = new Thread[workerPoolSize];
    for (int i=0; i < workerPoolSize; i++) {
      workers[i] = new Thread(new MyWorkerThread());  // however you build your worker threads
      workers[i].start();
    }
  }

  /**
   * This gets ran just before the class is destroyed.  You could use this to
   * shut down the threads
   */
  @PreDestroy
  public void dismantle() {
    // Tell each worker to stop
    for (Thread worker : workers) {
      worker.setRunning(false);
    }

    // Now join with each thread to make sure we give them time to stop gracefully
    for (Thread worker : workers) {
      worker.join();  // May want to use the one that allows a millis for a timeout
    }

  }

  /**
   * Sets the size of the worker pool.
   */
  public void setWorkerPoolSize(int newSize) {
    workerPoolSize = newSize;
  }
}