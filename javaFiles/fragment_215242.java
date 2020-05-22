public static void main(String[] args) {
    class NumberedThread implements Runnable {
        private final int number;
        public NumberedThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println("This is test. N: " + number);
        }
    }

    List<Thread> threadList = new ArrayList<>();
    for (int i = 1; i  <  6; i++) threadList.add(new Thread(new NumberedThread(i)));

    ExecutorService executor = Executors.newFixedThreadPool(10);;
    for (Thread thread : threadList) executor.execute(thread);
    executor.shutdown();
    try {
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
    catch (InterruptedException ignored) { }
}