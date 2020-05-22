public static class Main {
    private static List<String> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(
                new AutoUpdater(clients, lock.writeLock()),
                0,
                24,
                TimeUnit.HOURS);

        Lock readLock = lock.readLock();
        while (true) {
            try {
                readLock.lock();
                System.out.println("This is a test");
            } finally {
                readLock.unlock();
            }
        }
    }
}