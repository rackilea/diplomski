class Shop {
    private static BlockingQueue<Integer> cars = new ArrayBlockingQueue<>();
    private static int carNumber;
    private static Random RANDOM = new Random();

    public static void main(String[] args) {

        // you can add more mechanics here
        int mechanicsCount = 2;
        for (int i = 0; i < mechanicsCount; i++) {
            new Thread(createMechanic(String.format("Mechanic %d", i))).start();
        }

        ScheduledExecutorService producingScheduler = Executors.newSingleThreadScheduledExecutor();
        // add a new car every 300 ms
        producingScheduler.scheduleAtFixedRate(() -> {
            try {
                cars.put(carNumber++);
            } catch (InterruptedException e) { }
        }, 0, 300, TimeUnit.MILLISECONDS);
    }

    // the concurrently running code
    private Runnable createMechanic(String name) {
        return () -> {
            try {
                while (true) {
                    // synchronization happens here: queue is thread-safe
                    Integer car = cars.take();
                    System.out.printf("repairing car %s in thread %s\n", car, Thread.currentThread().getName());
                    // take some time repairing
                    int timeToRepair = RANDOM.nextInt(500);
                    Thread.sleep(timeToRepair);
                    System.out.printf("car %s is repaired, took %s ms\n", car, timeToRepair);
                }
            } catch (InterruptedException e) { }
        };

    }
}