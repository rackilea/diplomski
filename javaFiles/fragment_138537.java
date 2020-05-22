private void startMemoryUpdateSchedule(final ScheduledExecutorService service) {
    final ScheduledFuture<?> future = service.scheduleWithFixedDelay(new MemoryUpdateThread(), 1, UPDATE_MEMORY_SCHEDULE, TimeUnit.MINUTES);
    Runnable watchdog = new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    //handle it
                    startMemoryUpdateSchedule(service);
                    return;
                } catch (InterruptedException e) {
                    //handle it
                    return;
                }
            }
        }
    };
    new Thread(watchdog).start();
}