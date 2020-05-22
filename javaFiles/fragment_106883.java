AtomicBoolean shouldRun = new AtomicBoolean(true);
while (i < 40) {
  completionService.submit(new CancellableRunnable(shouldRun, getTask()));
  i++;
}
shouldRun.set(false);
executor.shutdown();