private HandlerThread mHandlerThread;
private Handler mBackgroundHandler;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mHandlerThread = new HandlerThread("SomeNameHere");
    mHandlerThread.start();
    mBackgroundHandler = new Handler(mHandlerThread.getLooper());

    mBackgroundHandler.post(new Runnable() {
        @Override
        public void run() {
            // I can do blocking network here.
        }
    });
}

@Override
protected void onDestroy() {
    super.onDestroy();
    mHandlerThread.quitSafely();
}