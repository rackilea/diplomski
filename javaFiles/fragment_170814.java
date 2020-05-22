public class CalendarReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("example", "Calendar changed (or the phone just booted)");
    }
}