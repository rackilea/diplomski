public class ScreenStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (Intent.ACTION_SCREEN_TURNED_OFF.equals(action)) {
            // Screen is off
        } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
            // Screen is on
        }
    }
}