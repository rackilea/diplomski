ScheduledExecutorService dataTimer = Executors.newScheduledThreadPool(1);

if(isDynamic)
{
    dataTimer.scheduleAtFixedRate(r, 0L, freq, TimeUnit.MILLISECONDS);
}
else
{
    dataTimer.submit(r);
}