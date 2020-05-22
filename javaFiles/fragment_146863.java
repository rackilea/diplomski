int counter = 0;
...
Handler handler = new Handler();
Runnable runnable = new Runnable() {

   public void run() {

       // it will be > 0 when run() will be called twice
       if (counter > 0) {
           dlg.show();

           // it made a trick now remove callbacks from Handler and return
           handler.removeCallbacks(runnable);
           return;
       }

       counter++;
       handler.postDelayed(runnable, 600);

   }
};
runnable.run();