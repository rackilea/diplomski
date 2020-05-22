Handler handler = new Handler();
Runnable test = new Runnable() {
    @Override
    public void run() {
        //do work
        handler.post(test, 4000); //wait 4 sec and run again
    }
};

public void stopTest() {
    handler.removeCallbacks(test);
}

public void startTest() {
    handler.post(test,0); //wait 0 ms and run
}