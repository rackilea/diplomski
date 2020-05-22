Timer timer = new Timer();
TimerTask task = new TimerTask()
{
    @Override
    public void run()
    {
        method();
    }
};
// every 3 seconds
timer.schedule(task, 0, 3000);