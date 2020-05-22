new Timer().scheduleAtFixedRate(new Send(),new Date(),30000);
...
Class Send extends TimerTask
{
    boolean shouldRun = true;
    public void run()
    {
            long start = System.currentTimeMillis();
            while(shouldRun)
            {
                    if(condition)
                            //send to db                        
            }
    }
}