final Handler handler = new Handler(); 
int count = 0;

final Runnable runnable = new Runnable() {
    public void run() { 
        // need to do tasks on the UI thread 
        Log.d(TAG, "Run test count: " + count);
        if (count++ < 5) {
            handler.postDelayed(this, 5000);
        }
    } 
}; 

// trigger first time 
handler.post(runnable);