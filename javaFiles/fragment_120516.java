public static void yourMethod(Context mContext) {

calintent = new Intent(mContext, AlarmBroadcastReceiver.class);
    calpendingintent = PendingIntent.getBroadcast(mContext.getApplicationContext(), 12345, calintent, 0);
    am = (AlarmManager)mContext.getSystemService(Activity.ALARM_SERVICE);
}