ExecutorService threadPool = Executors.newFixedThreadPool(100); 
for (int i = 0; i < 100; i++) {
    threadPool.submit(new Runnable() {
        public void run() {
            Channel threadChannel = // create channel here;
            while (!done) {
                // use the per-thread channel
            }
        }
    });
}