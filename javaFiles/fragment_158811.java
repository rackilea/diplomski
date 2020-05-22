boolean mStopHandler = false;
private Handler mHandler;

//initialize runnable in oncreate()
mHandler=new Handler();

Runnable runnable = new Runnable() {
    @Override
    public void run() {
        // do your stuff here 

        if (!mStopHandler) {
            mHandler.postDelayed(this, 5000);
        }
    }
};