RequestConfiguration conf= new RequestConfiguration.Builder().setTagForChildDirectedTreatment(TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE).build();

    MobileAds.setRequestConfiguration(conf);
    MobileAds.initialize(this, new OnInitializationCompleteListener() {
        @Override
        public void onInitializationComplete(InitializationStatus initializationStatus) {
        }
    });
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();

    mAdView.loadAd(adRequest);