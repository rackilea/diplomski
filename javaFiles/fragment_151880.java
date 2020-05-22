public void countIN (View view) {
counter++;
if (counter == 3){
    if (mInterstitialAd.isLoaded()){
        mInterstitialAd.show();
        view.(do something)
    }
}