@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Intent intent = new Intent(this, AlarmReceiver.class);
    final PendingIntent pendingIntent = PendingIntent.getBroadcast(this,  0, intent, 0);

    mAlarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

    // Cancel any existing service(s)
    mAlarmManager.cancel(pendingIntent);

    // Start service
    long alarmTime = System.currentTimeMillis() + 10000L; // 10 seconds from now
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        mAlarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);
    } else {
        mAlarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);
    }
}