private void startat12() {
    AlarmManager alarmManager;
    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    Calendar c = Calendar.getInstance();
    c.set(Calendar.HOUR_OF_DAY, 00);
    c.set(Calendar.MINUTE, 00);

    Long milliseconds = c.getTimeInMillis();
    Long daily = 24L * 60L * 60L * 1000L;

    //check if the time is already passed
    if (milliseconds < System.currentTimeMillis()) {
        //if already passed then push it for next day by adding just 24 hrs
        milliseconds = milliseconds + daily;
    }
    Intent intent = new Intent(YourActivity.this, MyReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(YourActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, milliseconds, pendingIntent);
    } else {
        alarmManager.set(AlarmManager.RTC_WAKEUP, milliseconds, pendingIntent);
    }
    String dateFormat = "dd/MM/yyyy HH:mm";
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    Toast.makeText(this, "Alarm is set for " + formatter.format(milliseconds), Toast.LENGTH_SHORT).show();
}