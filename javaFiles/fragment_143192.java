public static void main(String[] args) {
    SynchronousQueue<Runnable> queue = new SynchronousQueue<Runnable>() {
        @Override
        public boolean offer(Runnable runnable) {
            try {
                return super.offer(runnable, 1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
    };
    ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, queue);
    for (int i = 0; i < 10; i++) {
        final int finalI = i;
        pool.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(LocalTime.now() + " - " + Thread.currentThread().getName() + " " + finalI + " complete");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    pool.shutdown();
}