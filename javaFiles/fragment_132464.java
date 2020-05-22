public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        AdsManager androidManager = new AndroidAdsManager();
        initialize(new MyGame(androidManager), config);
    }
}