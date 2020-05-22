new Thread()
{
    public void run()
    {
        while(true)
            yourActivity.runOnUiThread(new Runnable()
            {
                public void run()
                {
                    doStuff();
                }
            });
    }
}.start();
return returnVal;