Handler timeThing = new Handler();    
Runnable timedWorker = new Runnable {
    public void run(){
        // Do work
        timeThing.postDelayed(this, 10000); // do it again later
    }
};
timeThing.postDelayed(timedWorker, 10000);