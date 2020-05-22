public class BadgesReceiver extends BroadcastReceiver {
    private static final String TAG = "BadgesReceiver";

    public static final String BADGES_UPDATE_ACTION = BuildConfig.PACKAGE_NAME + ".action.UPDATE_BADGES";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent != null ? intent.getAction() : null;
        Log.d(TAG, "onReceive action: " + action);
        if (!TextUtils.isEmpty(action) && action.equals(BADGES_UPDATE_ACTION)) {
            final Intent i = new Intent(context, MyService.class);
            i.setAction(MyService.UPDATE_BADGES_ACTION);
            context.startService(i);
        }
    }
}