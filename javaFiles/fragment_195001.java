fun setAlarm(context: Context, interval: Long) {
    val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val i = Intent(context, AlarmReceiver::class.java)
    val pi = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT) //Flag Update Current FLAG_CANCEL_CURRENT

    val prefTime = PreferenceManager.getDefaultSharedPreferences(context).getString(SettingsValues.NOTIFICATION_TIME_KEY, "1").toInt()
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, prefTime)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MINUTE, 0)
    var time = calendar.timeInMillis
    if (System.currentTimeMillis() > time) {
        time = time + 24 * 60 * 60 * 1000 // Next day
    }
    am.setRepeating(AlarmManager.RTC_WAKEUP,
            time , AlarmManager.INTERVAL_DAY, pi);
    isActive = true
}