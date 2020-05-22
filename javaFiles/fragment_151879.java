public void countIN () {
counter++;
if (counter == 3){
    if (mInterstitialAd.isLoaded()){
        mInterstitialAd.show();
    }
}