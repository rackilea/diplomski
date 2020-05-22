mAdView = new NativeExpressAdView(this);
int width = screenwidth - 16;
mAdView.setAdSize(new AdSize(width, 250)); 
mAdView.setAdUnitId("myAdUnitId");

// Create an ad request.
AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

// Optionally populate the ad request builder.
adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);

// Add the NativeExpressAdView to the view hierarchy.
layout.addView(mAdView);

// Start loading the ad.
mAdView.loadAd(adRequestBuilder.build());