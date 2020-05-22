@Inject ExecutorService executor;

public void scheduleCleanup(String parameter) {
   final SomeObject someObject = new SomeObject(parameter);
   executor.schedule((Runnable) () -> cleanupService.startCleanup(someObject),
            CLEANUP_TIMEOUT_SEC, TimeUnit.SECONDS);
}