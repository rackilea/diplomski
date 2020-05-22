ExecutorService e1 = Executors.newFixedThreadPool(20);
final ExecutorService e2 = Executors.newFixedThreadPool(2);

e1.execute(new Runnable() {
    public void run() {
        System.out.println("e1 started");

        e2.execute(new Runnable() {
            public void run() {
                System.out.println("e2 started");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("e2 completed");
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

    }
});

e1.shutdown();
System.out.println("e1 shut down signal send");

e1.awaitTermination(30, TimeUnit.MINUTES);
System.out.println("e1 terminated");

e2.awaitTermination(30, TimeUnit.MINUTES);
System.out.println("e2 terminated");