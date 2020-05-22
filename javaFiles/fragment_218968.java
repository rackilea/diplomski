private Runnable myRunnable = new Runnable() {
    public void run() {
        txtStatus.setText("hello");
    }
};

// somewhere in code
txtStatus.postDelayed(myRunnable, 1000);

// in onPause or onDestroy
txtStatus.removeCallbacks(myRunnable);