AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, AppConstants.ALARM_ID_TESTING, new Intent(
            AppConstants.FILTER_TESTING), PendingIntent.FLAG_UPDATE_CURRENT);

    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + millisAfterCurrent, pendingIntent);