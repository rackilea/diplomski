private Handler handler = new Handler();
runnable.run();

private Runnable runnable = new Runnable() 
{

public void run() 
{
     //
     // Do the stuff
     //
     if(clock_on == true) {

             executeClock();

     }

     handler.postDelayed(this, 1000);
}
};