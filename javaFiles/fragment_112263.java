ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor(new     ThreadFactory() {

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MY_REPEATING_JOB");
        }
});
Runnable jobToExecute = new MyJob();
scheduledExecutor.scheduleWithFixedDelay(jobToExecute, 0, 1, TimeUnit.NANOSECONDS);