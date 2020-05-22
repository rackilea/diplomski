Realm realm = null;
try {
    realm = Realm.getDefaultInstance();
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm transactionRealm) {
            setAlarmActive(true);
        }
    });
    Intent myIntent = new Intent(context, AlarmServiceBroadcastReciever.class);
    myIntent.putExtra("alarm", realm.copyFromRealm(this));
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent,PendingIntent.FLAG_CANCEL_CURRENT);
    AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, getAlarmTime().getTime(), pendingIntent);
} finally {
    if(realm != null) {
        realm.close();
    }
}