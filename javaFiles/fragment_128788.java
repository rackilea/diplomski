static final AtomicInteger sum = new AtomicInteger(0);

public static void main(String[] args) throws InterruptedException {

    ExecutorService pool = Executors.newCachedThreadPool();

    for (int i = 0; i < 1000; i++) {
        pool.execute(new Adding());
    }

    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.DAYS);

    System.out.println(" Is it done? : " + pool.isTerminated());
    System.out.println("Sum is " + sum);
}

static class Adding implements Runnable {

    public void run() {
        sum.addAndGet(1);
    }
}