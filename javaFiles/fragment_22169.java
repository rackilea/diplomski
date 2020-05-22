public class App extends Application implements IAviaryClientCredentials {

    @Override
    public void onCreate() {
        super.onCreate();
        AdobeCSDKFoundation.initializeCSDKFoundation(getApplicationContext());
        initialize();
    }

    public void initialize() {
        AdobeAuthManager manager = AdobeAuthManager.sharedAuthManager();
        manager.initWithApplicationContext(App.this);
        try {
            manager.setAuthenticationParameters("YOUR CLIENT ID WILL BE HERE", "YOUR CLIENT SECRET ID WILL BE HERE", null);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBillingKey() {
        return ""; // leave it blank
    }

    @Override
    public String getClientID() {
        return "YOUR CLIENT ID WILL BE HERE";
    }

    @Override
    public String getClientSecret() {
        return "YOUR CLIENT SECRET ID WILL BE HERE";
    }

}