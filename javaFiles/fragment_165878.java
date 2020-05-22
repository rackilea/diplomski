Handler handler;

    @Override
    public void onCreate() {
        // Handler will get associated with the current thread, 
        // which is the main thread.
        handler = new Handler();
        super.onCreate();
    }

    private void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }