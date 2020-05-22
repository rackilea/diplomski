final ScheduledExecutorService executor = /* ... */ ;

Runnable task = new Runnable() {
    @Override
    public void run() {
        ZonedDateTime now = ZonedDateTime.now();
        long delay = now.until(now.plusMonths(1), ChronoUnit.MILLIS);

        try {
            // ...
        } finally {
            executor.schedule(this, delay, TimeUnit.MILLISECONDS);
        }
    }
};

int dayOfMonth = 5;

ZonedDateTime dateTime = ZonedDateTime.now();
if (dateTime.getDayOfMonth() >= dayOfMonth) {
    dateTime = dateTime.plusMonths(1);
}
dateTime = dateTime.withDayOfMonth(dayOfMonth);
executor.schedule(task,
    ZonedDateTime.now().until(dateTime, ChronoUnit.MILLIS),
    TimeUnit.MILLISECONDS);