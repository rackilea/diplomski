public static void main(String[] args) throws InterruptedException {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime release = LocalDateTime.of(2019, 10, 30, 13, 30);

    long sleepDuration = Duration.between(now, release).toMillis();
    TimeUnit.MILLISECONDS.sleep(sleepDuration);
}