public class TaskRunnable implements Runnable {
    BlockingQueue<Task> queue;
    ...
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
             // restore interrupted status
             Thread.currentThread().interrupt();
        } 
    }
}