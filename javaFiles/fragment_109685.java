@Provides PendingIntent provideGcmKeepAlivePendingIntent() {
    System.out.println("pending intent provider");
    Intent gcmKeepAliveIntent = new Intent("com.gmail.npnster.first_project.gcmKeepAlive");
    return PendingIntent.getBroadcast(mContext, 0, gcmKeepAliveIntent, PendingIntent.FLAG_CANCEL_CURRENT);
}

@Provides  AlarmManager provideGcmKeepAliveAlarmManager() {
    return (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
}