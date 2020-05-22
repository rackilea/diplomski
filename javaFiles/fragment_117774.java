public static void main(String[] args) {

    final int noOfThreads = 2;
    final int noOfTasks = 10;

    //create thread pool with given size 
    ExecutorService service = Executors.newFixedThreadPool(noOfThreads);

    // queue some tasks 
    for (int i = 0, int nextId = 1; i < noOfThreads; i++, nextId += noOfTasks) {
        service.submit(new ThreadTask(nextId, noOfTasks));
    }
}

class ThreadTask implements Runnable {
    private final int id;
    private int noOfTasks;

    public ThreadTask(int nextId, int noOfTasks) {
        this.id = nextId;
        this.noOfTasks = noOfTasks;
    }

    public void run() {

        for (int i = id; i < id + noOfTasks; i++) {
            System.out.println(i);
        }
    }
}