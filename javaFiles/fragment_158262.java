public class classAds{

private InterstitialAd mInterstitialAd;

public void mobileAds(Activity activity)
{
    MobileAds.initialize(activity,
            "ca-app-pub-3940256099942544~3347511713");

    mInterstitialAd = new InterstitialAd(activity);
    mInterstitialAd.setAdUnitId("ca-app-pub-.............");

   }