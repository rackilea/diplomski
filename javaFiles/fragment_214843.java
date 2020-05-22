protected void onCreate(Bundle savedInstanceState) {

    // ...
    // some irrelevant code here
    // ...

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };
    registerReceiver(broadcastReceiver, new IntentFilter("finish.goodhour.activity"));
    AlarmManager manager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(
            getApplicationContext(),
            (int) Calendar.getInstance().getTimeInMillis(),
            new Intent().setAction("finish.goodhour.activity"),
            PendingIntent.FLAG_UPDATE_CURRENT
    );
    manager.set(AlarmManager.RTC_WAKEUP,
            Calendar.getInstance().getTimeInMillis() + 1000 * 60 * 60,
            pendingIntent);
}