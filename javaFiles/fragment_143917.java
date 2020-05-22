public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Worker worker = new Worker();
        executorService.execute(worker);
        executorService.shutdownNow();
    }

    public static class Worker extends Thread {

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("work " + Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
            }
            System.out.println("Thread has been interrupted");
        }
    }
}