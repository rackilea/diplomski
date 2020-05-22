final Duration countdownDuration = Duration.ofSeconds(5);
Thread timer = new Thread(() -> {
    LocalTime start = LocalTime.now();
    LocalTime current = LocalTime.now();
    LocalTime end = start.plus(countDownDuration);

    while (end.isAfter(current)) {
        current = LocalTime.now();
        final Duration elapsed = Duration.between(current, end);

        Platform.runLater(() -> timeLeft.set(current)); // As the label is bound to timeLeft, this line must be inside Platform.runLater()
        Thread.sleep(1000);
    }
});