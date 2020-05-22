Handler handler = new Handler();
Runnable timedTask = new Runnable(){

    @Override
    public void run() {
        getUrlText();
        handler.postDelayed(timedTask, 1000);
    }};