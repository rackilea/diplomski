public static void main(String [] args) throws InterruptedException {

        MockDB database = new MockDB();

        System.out.println("starting tasks\n");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new ScheduledUpdater(database, "a"), 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new ScheduledUpdater(database, "b"), 0, 1, TimeUnit.SECONDS);

        // run test for 5 seconds
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();

        // let all threads to stop
        Thread.sleep(250);
        System.out.println("\ntasks stopped; json: " + database.getJSON());
    }