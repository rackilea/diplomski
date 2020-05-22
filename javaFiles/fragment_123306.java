Activity.java

    import com.google.android.gms.ads.AdRequest;
    import com.google.android.gms.ads.InterstitialAd;

    public class MainActivity extends Activity {

        public static InterstitialAd mInterstitialAd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mInterstitialAd.setAdListener(new AdListener() {
    @Override
    public void onAdLoaded() {
        // Code to be executed when an ad finishes loading.
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        // Code to be executed when an ad request fails.
    }

    @Override
    public void onAdOpened() {
        // Code to be executed when the ad is displayed.
    }

    @Override
    public void onAdLeftApplication() {
        // Code to be executed when the user has left the app.
    }

    @Override
    public void onAdClosed() {
        // Code to be executed when when the interstitial ad is closed.
    }
});
            // Make sure to set the adapter after the above code.
        }

      public static void ShowAd()
        {
           if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }
    }