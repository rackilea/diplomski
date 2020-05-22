public class ShutDownReceiver extends BroadcastReceiver {

    private static final String TAG = "ShutDownReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (Intent.ACTION_SHUTDOWN.equals(action)){

            DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            ComponentName cn = AdminReceiver.getComponentName(context);

            if (dpm != null && dpm.isDeviceOwnerApp(context.getPackageName())) {
                //This is a custom method
                setUserRestriction(dpm, cn, UserManager.DISALLOW_USB_FILE_TRANSFER, false);
            }
            Toast.makeText(context, "Shutting Down", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: ACTION_SHUTDOWN");
        }
    }
}