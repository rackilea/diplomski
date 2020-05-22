@Override
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState); 
  setContentView(R.layout.activity_main);

  adView = (AdView) findViewById(R.id.adView);
  adView.setAdUnitId(AD_UNIT_ID);
  adView.setAdSize(AdSize.BANNER);

  AdRequest adRequest = new AdRequest.Builder().build();
  adView.loadAd(adRequest);

  //.... rest of your onCreate() code
}