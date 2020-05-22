private void startCounter() {

    handler = new Handler();
    runnable = new Runnable() {

    @Override
    public void run() {
        if(buttonIDs[3]==0){ // if the last id is still zero lets clear everything and start afresh
             clearEverything();
          }                       
    }
 }
    handler.postDelayed(runnable,1000); // we tell it dont execute the code in run until a 1000 milliseconds which is 1 second
}