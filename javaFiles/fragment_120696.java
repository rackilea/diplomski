int delay = 10000;
static boolean running = true;
new Handler().postDelayed(new Runnable() {
    public void run(){
        if (running) {
            new Handler().postDelayed(this, delay);
        }
    }
}, delay);

public void onDestroy() {
    super.onDestroy();
    stopSelf();
    running = false;
}