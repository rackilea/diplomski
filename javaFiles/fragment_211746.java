@Scheduled(fixedRate = 2000)
 public void scheduleTaskWithFixedRate() {
   // ...
}

@Scheduled(fixedDelay = 2000)
 public void scheduleTaskWithFixedDelay() {
   // ...
}

@Scheduled(fixedRate = 2000, initialDelay = 5000)
 public void scheduleTaskWithFixedRateAndInitialDelay() {
   // ...
}

@Scheduled(cron = "0 * * * * ?")
public void scheduleTaskWithCronExpression() {
  // ...
}