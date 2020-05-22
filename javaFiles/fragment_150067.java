public void connectService(final MyketCustomCallback callback) {
        Log.d("dd", "Creating helper.");
        mMyketHelper = new MyketSupportHelper(context);
        // Enable debug logging (for a production application, you should set this to false).
        mMyketHelper.enableDebugLogging(true);

        // Start setup. This is asynchronous and the specified listener will be called once setup completes.
        Log.d("dd", "Starting setup.");

        mMyketHelper.startSetup(new MyketSupportHelper.OnMyketSetupFinishedListener() {
            @Override
            public void onMyketSetupFinished(MyketResult result) {
                Log.d("dd", "Setup finished.");
                if (!result.isSuccess()) {
                    // Here i set that value by setter
                    setServiceConnected(false);
                    callback.myketServiceComplete(false);
                    return;
                }
                // Here i set that value by setter
                setServiceConnected(true);
                callback.myketServiceComplete(true);
                mMyketHelper.getAppUpdateStateAsync(mCheckAppUpdateListener);
            }
        });
    }