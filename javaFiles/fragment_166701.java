public static void main(String[] args) {
    List<String> cmds = Lists.newArrayList("sleep 1", "sleep 2", "sleep 3");

    final ExecutorService pool;
    int threadsnum = Runtime.getRuntime().availableProcessors() - 2;
    pool = Executors.newFixedThreadPool(threadsnum);


    CountDownLatch latch = new CountDownLatch(cmds.size());


    for (final String cmd : cmds) {
        pool.submit(() -> {
            try {
                System.out.println("to be executed: " + cmd);
                Runtime.getRuntime().exec(cmd).waitFor();
                latch.countDown();
            }
            catch (IOException e) {
                Thread.currentThread().interrupt();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    try {
        latch.await(10, TimeUnit.SECONDS);
        if (latch.getCount() > 0) {
            System.out.println("Waited long enough. There are " + latch.getCount() + " threads still running");
        }
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    }
    finally {
        pool.shutdown();
    }
    System.out.println("Completed.");

}