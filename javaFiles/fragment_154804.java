AlarmManager am = ( AlarmManager ) getSystemService( Context.ALARM_SERVICE );
Intent alarmIntent = new Intent( "CHECK_DATABASE" );
PendingIntent pi = PendingIntent.getBroadcast(context, 0 , alarmIntent, 0 );
int type = AlarmManager.ELAPSED_REALTIME_WAKEUP;
long interval = POLLING_INTERVAL_IN_MILLISECONDS;
long triggerTime = SystemClock.elapsedRealtime() + interval;
// For short intervals setInexact repeating is same as exactRepeating, use at least fifteen minutes to make it more efficient
am.setInexactRepeating( type, triggerTime, interval, pi );
Log.i(TAG, "Set inexact alarm through AlarmManager");
}