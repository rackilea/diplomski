public class HW5 {
    public static void main(String[] argv) throws InterruptedException, ExecutionException {
    FutureTask<Boolean> myFutureTask = new FutureTask<>(new Callable<Boolean>() {

        @Override
        public Boolean call() throws Exception {
        // implement the logic here and return true if everything was
        // ok, false otherwise.
        Thread.sleep(5000);
        System.out.println("dddd");
        return System.currentTimeMillis() % 2 == 0;
        }
    });

    ExecutorService executor = Executors.newFixedThreadPool(1);
    executor.execute(myFutureTask);
    Boolean result = myFutureTask.get();
    System.out.println("Done!");
    }
}