class Task implements Runnable{
    private final AtomicInteger v1 = new AtomicInteger(10);

    private String name;

    public void run() {
       System.out.println("Thread is: " + Thread.currentThread().getName() + " " + v1.addAndGet(10));
    }

}
public class ThreadPoolTest{

    public static void main(String[] args) {
        Runnable r1 = new Task();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(r1);
        executor.execute(r1);
        executor.execute(r1);
        executor.shutdown();
    }
}