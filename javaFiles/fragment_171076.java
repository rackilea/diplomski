// declare this variables as attributes in you class
Handler handler = new Handler();
Runnable runnable = new Runnable() {
    public void run() {
        // Call something when it finishes
    }
};
handler.postDelayed(runnable, 60_000);

// and if you want to cancel the timer, you can cancel it this way
handler.removeCallbacks(runnable);