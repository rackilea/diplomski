public void retryTask(final HandlerId<String> handlerId,
                      final String timerId,
                      final Integer intervalTimeMinutes,
                      final Integer retryTimeMinutes) {
    this.timerService.createTimerRunRepeatedly(handlerId,
            timerId,
            "timer",
            getTotalFireCount(intervalTimeMinutes, retryTimeMinutes),
            (int) TimeUnit.MINUTES.toMillis(intervalTimeMinutes),
            0,
            null).thenAccept(timerWasCreated -> {
        if (timerWasCreated) {
            System.out.println("Timer was created");
        } else {
            System.out.println("Error while creating timer");
        }
    });
}