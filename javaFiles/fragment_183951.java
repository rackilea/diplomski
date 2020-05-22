public static void main(String[] args) {
    Calendar thatDay = Calendar.getInstance();
    thatDay.set(Calendar.DAY_OF_MONTH, 25);
    thatDay.set(Calendar.MONTH, 11); // 0-11 so 1 less
    thatDay.set(Calendar.YEAR, 2014);
    thatDay.set(Calendar.HOUR, 0);
    thatDay.set(Calendar.MINUTE, 0);
    thatDay.set(Calendar.SECOND, 0);
    thatDay.set(Calendar.AM_PM, 0);
    System.out.println(thatDay.getTime());
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    scheduledExecutorService.scheduleAtFixedRate(new ReadPeriodically(thatDay), 0, 1, TimeUnit.SECONDS);

}