public static void createAlarms(Context mContext) {
    totaltimetaken = totaltimetaken + timetaken;
    totalcost = totalcost + costone; 
    cal = Calendar.getInstance();
    //cal.add(Calendar.HOUR, alarmintervalint);
    cal.add(Calendar.SECOND, alarmintervalint);
    calintent = new Intent(mContext, AlarmBroadcastReceiver.class);
    calpendingintent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 12345, calintent, 0);
    am = (AlarmManager)mContext.getSystemService(Activity.ALARM_SERVICE);
    am.set(AlarmManager.RTC_WAKEUP, alarmintervalint, calpendingintent);
}