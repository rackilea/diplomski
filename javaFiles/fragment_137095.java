@Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
@Timeout
public void runWorkerManager() {
    final boolean jobProcessed = this.workerManager.execute();
    if (jobProcessed) {
        timerService.createTimer(10L, "Check for more jobs...");
    }
}