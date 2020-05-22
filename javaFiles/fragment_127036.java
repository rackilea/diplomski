AdView mAdView = new AdView(this);
AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();
drawerLayoutContainer.addView(mAdView);
mAdView.loadAd(adRequest);