void myMethodCallingShowInterstitial() {
    ... doing my other background stuff ...
    // replace showInterstitial(); with below:
    activityReference.runOnUiThread(new Runnable() {
        @Override public void run() {
            activityReference.showInterstitial();
        }
    });
    ... doing my other background stuff ...
}