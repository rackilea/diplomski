final BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<Runnable>();

public void submit(Runnable runs) {
    tasks.add(runs);
}

volatile boolean running = true;

// running in each thread in the pool
class RunsRunnable implement Runnable {
    public void run() {
        while(running) {
           Runnable runs = tasks.take();
           try {
              runs.run();
           } catch(Throwable t) {
              // handles t
           }
        }
    }
 }