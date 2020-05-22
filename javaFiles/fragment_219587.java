public void onEventMainThread(EventAppStateChanged event) {
        if (event.isState(AppState.NORMAL)) {
            Log.i(TAG, "EventAppStateChanged (to NORMAL) received");
            try {
                for (Runnable runnable : toBeExecutedList) {
                    Log.i(TAG, "FutureExecutor executing Runnable: " + runnable);
                    VCEngine.getHandler().postDelayed(runnable, 10);
                    toBeExecutedList.remove(runnable);
                }
            } catch (Exception e) {
                Log.e(TAG, "FutureExecutor exception: ");
                e.printStackTrace();
            }
        }
    }