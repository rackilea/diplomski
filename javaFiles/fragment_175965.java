Int interval = 800; // milliseconds
Handler handler = new Handler()
Runnable runnable = new Runnable() { 

   @Override void run() {

        //
        // do your logic here
        //

        // decrement interval by 20 milliseconds 
        // if interval - 20 is greater than 200
        interval = interval - 20 > 200 ? interval - 20 : interval;


        // Request an execution of this runnable with the new value of interval
        handler.postDelayed(runnable, interval);
   }
}


public void start() {
   handler.postDelayed(runnable, interval);
}

public void stop() { 
   handler.removeCallbacks(runnable);
}