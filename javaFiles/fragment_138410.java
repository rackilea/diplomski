public void showInterstitial() {
    if(Looper.myLooper() != Looper.getMainLooper()) {
        runOnUiThread(new Runnable() {
            @Override public void run() {
                doShowInterstitial();
            }
        });
    } else {
        doShowInterstitial();
    }
}
private void doShowInterstitial() {
    if (iAd.isLoaded()) {
        iAd.show();
    } else {
        //Log.d(TAG, "Interstitial ad is not loaded yet");
    }
}