public static void main( String[] args )
{
    ExecutorService executor = Executors.newFixedThreadPool(1);
    TestThread t1 = new TestThread(1);
    TestThread t2 = new TestThread(2);
    executor.submit(t1);
    Future<?> f2 = executor.submit(t2);
    try {
        f2.get();
    } catch (InterruptedException | ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    ThreadPoolExecutor tt = (ThreadPoolExecutor) executor;
    System.out.println(tt.getActiveCount()); //ensuring that there is no active threads in the pool after last thread terminates
}

public static class TestThread implements Runnable{
    private int id;

    public TestThread(int num){
        id = num;
    }
    public void run() {
        System.out.println("running thread: " + id);
        try {
            Thread.sleep(2000);
            System.out.println("After sleeping thread " + id);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}