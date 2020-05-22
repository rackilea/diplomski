setContentView(R.layout.main);

    RelativeLayout layout = (RelativeLayout)findViewById(R.id.vMain);
    layout.addView(gameCanvas);
    AdView adView = (AdView) this.findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().addTestDevice("91BA1C88FB7946232E39E67D0C066208").build();
    adView.loadAd(adRequest);