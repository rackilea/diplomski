import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MyActivity extends Activity {
    private InterstitialAd interstitial;
    private boolean loaded = false;
    private static MyActivity appActivity;
    AdRequest adRequest;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appActivity = this;
        createAdmob();
    }

    private void createAdmob() {
        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("YOUR UNIT ID");

        // Create ad request.
        adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
        loaded = true;

    }

    public static void nativeDisplayAd() {

        appActivity.displayAd();
    }

    public void displayAd() {
        // Just to load ad before display as required from admob sdk.
        if (loaded) {
            displayInterstitial();
            loaded = false;
        } else {
           // or only load new ad.
            createAdmob();
        }
    }
    // Invoke displayInterstitial() when you are ready to display ad
    // interstitial.
    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}