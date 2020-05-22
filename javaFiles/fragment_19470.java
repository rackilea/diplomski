interstitial.setAdListener(new AdListener() {
    @Override
    public void onAdLoaded() {

            if (interstitial.isLoaded()) {
                interstitial.show();
            }

    }

    @Override
    public void onAdOpened() {


    }

    @Override
    public void onAdFailedToLoad(int errorCode) {

    }
});