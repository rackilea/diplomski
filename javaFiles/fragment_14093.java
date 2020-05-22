Calendar calendar = Calendar.getInstance();

    // 8 AM Each day 
    calendar.set(Calendar.HOUR_OF_DAY, 8);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    PendingIntent pi = PendingIntent.getService(context, 0, new Intent(context, MyClass.class), PendingIntent.FLAG_UPDATE_CURRENT);
    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);