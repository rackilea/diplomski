LocalDateTime now = LocalDateTime.now();
Duration runningTime = Duration.between(startTime, now);
Duration timeLeft = duration.minus(runningTime);
if (timeLeft.isZero() || timeLeft.isNegative()) {
    timeLeft = Duration.ZERO;
    // Stop the timer and reset the UI
}