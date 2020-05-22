@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    AdView adView = (AdView)findViewById(R.id.adView);
    View contentFrame = findViewById(R.id.contentFrameLayout);

    RelativeLayout parent = (RelativeLayout) adView.getParent();
    LayoutParams mapFrameParams = contentFrame.getLayoutParams();
    LayoutParams adViewParams = adView.getLayoutParams();

    parent.removeView(adView);
    parent.removeView(contentFrame);

    AdView newAdView = new AdView(this, AdSize.SMART_BANNER, getString(R.string.admob_pubId));

    newAdView.setId(R.id.adView);

    parent.addView(newAdView, adViewParams);
    parent.addView(contentFrame,mapFrameParams);
    newAdView.loadAd(new AdRequest());
}