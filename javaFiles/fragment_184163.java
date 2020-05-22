final ScheduledExecutorService executor = /* ... */ ;

Runnable task = new Runnable() {
    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        long delay =
            calendar.getTimeInMillis() - System.currentTimeMillis();

        try {
            // ...
        } finally {
            executor.schedule(this, delay, TimeUnit.MILLISECONDS);
        }
    }
};

int dayOfMonth = 5;

Calendar calendar = Calendar.getInstance();
if (calendar.get(Calendar.DAY_OF_MONTH) >= dayOfMonth) {
    calendar.add(Calendar.MONTH, 1);
}
calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
executor.schedule(task,
    calendar.getTimeInMillis() - System.currentTimeMillis(),
    TimeUnit.MILLISECONDS);