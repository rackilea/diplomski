if (counter == 3) {
    if (mInterstitialAd.isLoaded()) {
        mInterstitialAd.show();
    }
    counter = 0
}