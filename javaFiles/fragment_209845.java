public class ChartboostActivity extends Activity {
    private Chartboost cb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chartboostmain);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Configure Chartboost
        this.cb = Chartboost.sharedChartboost();

        String appId = "XXXXXXXXXXXXXX";
        String appSignature = "XXXXXXXXXXXXXXX";
        this.cb.onCreate(this, appId, appSignature, null);
        //this.cb.setImpressionsUseActivities(true);
        CBPreferences.getInstance().setImpressionsUseActivities(true);
    }

    @Override
    public void onStart() {
         super.onStart();
         this.cb.onStart(this);
         // Notify the beginning of a user session. Must not be dependent on user actions or any prior network requests.
         this.cb.startSession();
         // Show an interstitial
         //this.cb.showInterstitial(); 
         this.cb.showMoreApps();
         finish();
    }

    @Override
    protected void onStop() {
        //finish();
        super.onStop();

        this.cb.onStop(this);
    }

    @Override
    protected void onDestroy() {        
        //finish();
        super.onDestroy();

        this.cb.onDestroy(this);
    }

    @Override
    public void onBackPressed() {
         // If an interstitial is on screen, close it. Otherwise continue as normal.
         if (this.cb.onBackPressed())
         {
             finish();
             return;
         }
         else    
             super.onBackPressed();
    }
}