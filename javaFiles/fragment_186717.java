static int clicksCount,newsCount;
private InterstitialAd mInterstitialAd;

public void interstitalAd() {
    clicksCount++;
    if (clicksCount % 3 == 0) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}