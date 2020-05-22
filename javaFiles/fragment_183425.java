Handler handler = new Handler();
final Runnable r = new Runnable()
{
    public void run() 
        {
             //do your stuff here
              handler.postDelayed(this, 1000);
        }
};

handler.postDelayed(r, 1000);