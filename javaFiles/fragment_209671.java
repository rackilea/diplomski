private void startLocationTracker() {
    // Configure the LocationTracker's broadcast receiver to run every 5 minutes.
    Intent intent = new Intent(this, LocationTracker.class);
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis(),
            LocationProvider.FIVE_MINUTES, pendingIntent);
}