public class YourActivity extends Activity implements NativeAdsManager.Listener {

    private NativeAdsManager manager; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        manager = new NativeAdsManager(this, "YOUR_PLACEMENT_ID", 5);
        manager.setListener(this);
        manager.loadAds();

    }
}