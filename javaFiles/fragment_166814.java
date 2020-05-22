public class RegistrationIntentService extends IntentService {

    private static final String TAG = "GCM";
    public static final String TOKEN_ID = "registration_id";
    private final static int MAX_ATTEMPTS = 5;
    private final static int BACKOFF_MILLI_SECONDS = 2000;

    /**
     * Constructor
     */
    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

            // In the (unlikely) event that multiple refresh operations occur simultaneously, ensure that they are processed sequentially.
            synchronized (TAG) {
                Random random = new Random();
                String token = null;
                InstanceID instanceID = InstanceID.getInstance(this);
                long backoff = BACKOFF_MILLI_SECONDS + random.nextInt(1000);
                for (int i = 1; i <= MAX_ATTEMPTS; i++) {
                    try {
                        token = instanceID.getToken(getString(R.string.gcm_sender_id);, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                        if(null != token && !token.isEmpty()) {
                             break;
                        }
                    } catch (IOException e) {
                        //Log exception
                    }
                    if (i == MAX_ATTEMPTS) {
                            break;
                        }
                        try {
                            Thread.sleep(backoff);
                        } catch (InterruptedException e1) {
                            break;
                        }
                    // increase backoff exponentially
                    backoff *= 2;
                }
                // further processing for token goes here
            }
    }