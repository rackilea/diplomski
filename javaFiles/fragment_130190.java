private ScheduledExecutorService ses = 
    Executors.newSingleThreadScheduledExecutor();
private ScheduledFuture<?> bomb = null;

public void reset() {
    if(bomb != null) {
        bomb.cancel();
    }
    boom = ses.schedule(new Runnable() {
        @Override
        public void run() {
            throw new IllegalStateException("Boom");
        }
    }, 60, TimeUnit.SECONDS);
}