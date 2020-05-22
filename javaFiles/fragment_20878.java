private static Date getMidnight(){
    Calendar cal = new GregorianCalendar();
    cal.add(Calendar.DAY_OF_MONTH,1);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    return cal.getTime();
}

long initialDelay = (getMidnight().getTime() - System.currentTimeMillis())/1000;
final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, initialDelay, 10, SECONDS);