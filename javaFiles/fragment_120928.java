public class TestPool {

    public static void main(String[] args) {

        // create thread pool with given size
        ExecutorService service = Executors.newFixedThreadPool(10); 

        long startTime = System.currentTimeMillis();
        long endTime = startTime + (30 * 60 * 1000);

        ThreadTask[] threadTasks = new ThreadTask[threads];
        for (int i = 0; i < threads; i++) {
            threadTasks[i] = new ThreadTask(endTime);
        }

        for (ThreadTask tt : threadTasks) {
            service.submit(tt);
        }

        // wait for termination        
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS); 
    }
}