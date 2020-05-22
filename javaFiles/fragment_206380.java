public void startTimer(long gap)
{
    TimerHandler handler = new TimerHandler();
    handler.set(gap);
    handler.sendEmptyMessageDelayed(-1, 100);
}

startTimer(2000);