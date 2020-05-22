// Initialize the Mobile Ads SDK.
MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

// Create the InterstitialAd and set the adUnitId.
mInterstitialAd = new InterstitialAd(this);

// Defined in res/values/strings.xml
mInterstitialAd.setAdUnitId(getString(R.string.ad_unit_id));

if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
}