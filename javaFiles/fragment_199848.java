TimerTask task = new TimerTask ()
{
    private int state = 0;

    @Override
    public void run ()
    {
        System.out.println ("State is: " + state);
        state += 1;
    }
};

new Timer ().schedule (task, 0L, 1000L);