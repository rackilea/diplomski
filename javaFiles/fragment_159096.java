// create a thread pool with 10 workers
ExecutorService threadPool = Executors.newFixedThreadPool(10);
// or you can create an open-ended thread pool
// ExecutorService threadPool = Executors.newCachedThreadPool();
for (Job job : jobsToDo) {
    threadPool.submit(new MyJobProcessor(job));
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();
...
public class MyJobProcessor implements Runnable {
    private Job job;
    public MyJobProcessor(Job job) {
        this.job = job;
    }
    public void run() {
        // process the job
    }
}