package cominfinitygaminghere.wixsite.httpsinfinitygaminghere.mumbojumbo;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;
    import com.google.android.gms.ads.AdListener;
    import com.google.android.gms.ads.AdRequest;
    import com.google.android.gms.ads.AdView;
    import com.google.android.gms.ads.InterstitialAd;

    public class MainActivity extends AppCompatActivity {

        WebView webView;

        private InterstitialAd mInterstitialAd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mInterstitialAd = newInterstitialAd();
            loadInterstitial();

            AdView adView = (AdView) findViewById(R.id.adView);

            AdRequest adRequest = new AdRequest.Builder()
                    .setRequestAgent("android_studio:ad_template").build();

            adView.loadAd(adRequest);

            webView = (WebView) findViewById(R.id.webview1);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://www.youtube.com/channel/UChFur_NwVSbUozOcF_F2kMg");

         }   // insert closing bracket here

        public void loadInterstitial() {
            AdRequest adRequest = new AdRequest.Builder()
                    .setRequestAgent("android_studio:ad_template").build();
            mInterstitialAd.loadAd(adRequest);

            // Show the ad if it's ready. Otherwise toast and reload the ad.
            if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                //code to go to next level of the app
            }
        }


        private InterstitialAd newInterstitialAd() {
            InterstitialAd interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    // Code for proceeding to next level here

                }
            });
            return interstitialAd;
        }
    }