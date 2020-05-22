class TimerHandler extends Handler
{
    private long start;
    private long timeGap;

    public void set(long gap)
    {
        start = System.currentTimeMillis();
        this.timeGap = gap;
    }

    @Override
    public void handleMessage(Message msg)
    {
        long curr = System.currentTimeMillis();
        if(curr - start > timeGap)
        {
            // do what you want.
            // If you want your timer to keep on running,
            // reset start.
        }

        // send Next Message after 100 ms.
        sendEmptyMessageDelayed(-1, 100);
    }
}