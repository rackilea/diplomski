private Handler handler = new Handler();
Runnable task = new Runnable() {
    @Override
    public void run() {
        myCycle();
        handler.postDelayed(this, 100000);
    }
};
handler.removeCallbacks(task);
handler.post(task);