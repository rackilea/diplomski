public class classAds{

private InterstitialAd mInterstitialAd;


public void mobileAds()
{
    MobileAds.initialize(ApplicationClass.getContext,
            "ca-app-pub-3940256099942544~3347511713");

    mInterstitialAd = new InterstitialAd(ApplicationClass.getContext);
    mInterstitialAd.setAdUnitId("ca-app-pub-.............");

}