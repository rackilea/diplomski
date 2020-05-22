ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

...

while(...){
    final Future<?> f = pool.submit(...);

    service.schedule(new Runnable() {
        @Override
        public void run() {
            if(!f.isDone()){
                f.cancel(true);
            }
        }
    }, 1, TimeUnit.MINUTES);
}

service.awaitTermination(1, TimeUnit.MINUTES);
service.shutdown();