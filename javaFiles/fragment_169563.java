public class AlarmReceiver extends BroadcastReceiver {

    public AlarmReceiver() { }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "AlarmService Triggered.", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getSimpleName(), "Service triggered");
    }
}