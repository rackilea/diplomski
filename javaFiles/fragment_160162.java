@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    mInterstitialAd = new InterstitialAd(this);

    // set the ad unit ID
    mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

    // Call adView here
    adView();

    TextView playctv = (TextView) findViewById(R.id.textView);

    SharedPreferences prefsplay = this.getSharedPreferences("myPrefsKey",
        Context.MODE_PRIVATE);
    playcount = prefsplay.getInt("play_number", 0);
    playctv.setText(String.valueOf(playcount));
}