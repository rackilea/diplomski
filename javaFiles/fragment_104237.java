public void prepareAd() {
    if (interstitialAd != null && interstitialAd.isLoaded())
    {
        interstitialAd.show();
    }
    else
        {
            Log.d("tag","Ads is not loaded");
        }
}