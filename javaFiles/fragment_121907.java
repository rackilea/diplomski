Handler handler = new Handler();
Runnable test = new Runnable() {
    @Override
    public void run() {
        //do work
        //String msg = textMessage.getText().toString();
        // send message to server
        handler.post(test, 10000); //wait 10 sec and run again
    }
};

public void stopTest() {
    handler.removeCallbacks(test);
}

public void startTest() {
    handler.post(test,0); //wait 0 ms and run
}