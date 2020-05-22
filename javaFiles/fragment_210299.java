final Timer timer = new Timer();
// Note that timer has been declared final, to allow use in anon. class below
timer.schedule( new TimerTask()
{
    private int i = 10;
    public void run()
    {
        System.out.println("30 Seconds Later");
        if (--i < 1) timer.cancel(); // Count down ten times, then cancel
    }
}, 30000, 30000 //Note the second argument for repetition
);