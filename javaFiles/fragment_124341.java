ExecutorService service = Executors.newFixedThreadPool(5);
for(int i = 0; i < 5; i++) {
    service.execute(new Runnable() {
        public void run() {
            doWork();
        }
    });
}
service.shutdown();