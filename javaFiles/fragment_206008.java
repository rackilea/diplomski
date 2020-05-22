@Override
    protected void onPause() {
        super.onPause();
        mTimer.cancel();
        mTimer.purge();
        mTimer = null;
    }