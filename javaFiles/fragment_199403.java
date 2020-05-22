public class AnalyticsActivity extends Activity {

    private static final String KEY_INTERNAL_COMPONENT = "com.tests.AnalyticsReceiver.COMPONENT";
    private static final String KEY_NOTIFICATION_TYPE = "com.tests.AnalyticsReceiver.NOTIFICATION_TYPE";
    private static final String KEY_USERNAME = "com.tests.AnalyticsReceiver.USERNAME";

    public static Intent getLaunchIntent(
            Context context, Intent intent, long notificationType, String username) {
        intent.putExtra(KEY_INTERNAL_COMPONENT, intent.getComponent());
        intent.setComponent(new ComponentName(context, AnalyticsActivity.class));
        intent.putExtra(KEY_NOTIFICATION_TYPE, notificationType);
        intent.putExtra(KEY_USERNAME,username);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            Intent intent=getIntent();
            long notifType=intent.getLongExtra(KEY_NOTIFICATION_TYPE, 0);
            String username=intent.getStringExtra(KEY_USERNAME);
            Log.e("RegisterEvent", "notif=" + notifType + ",username=" + username);
            ComponentName componentName=intent.getParcelableExtra(KEY_INTERNAL_COMPONENT);
            intent.setComponent(componentName);
            startActivity(intent);
        }
    }

}