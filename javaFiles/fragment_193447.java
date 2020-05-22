public class Producer implements Runnable {

private ExecutorService consExec;
private List<Long> list;

public Producer(ExecutorService exec, List<Long> list) {
    this.consExec = exec;
    this.list = list;
}

    public void run() {
        for (Long id: list) {
            if(Thread.currentThread().isInterrupted()){
               //the shutdownNow method has been called (or may a future.cancel(true))
            }
            data = get data from db for the id
            consExec.execute(new Consumer(data));
        }
    }
}