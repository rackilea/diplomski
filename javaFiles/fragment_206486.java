final Handler handler = new Handler();

final int[] count = {0};        //<--changed here
final Runnable runnable = new Runnable() {
    public void run() {

        // need to do tasks on the UI thread
        Log.d(TAG, "runn test");


        if (count[0]++ < 5)     //<--changed here
            handler.postDelayed(this, 5000);

    }
};

// trigger first time
handler.post(runnable);