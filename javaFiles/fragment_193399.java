final Handler handler=new Handler();

final Runnable runnable = new Runnable()
{
    public void run() 
    {
        //This will run every 1000ms. Put code here(UI safe)
        handler.postDelayed(this, 1000);
    }
};

handler.postDelayed(runnable, 1000);