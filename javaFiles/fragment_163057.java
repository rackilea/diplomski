boolean alarmExists = (PendingIntent.getBroadcast(context, 0, pendingIntent, PendingIntent.FLAG_NO_CREATE) != null);

// remove any pre-existing alarms associated with this Intent
if (alarmExists) {
   alarmManager.cancel(pendingIntent)
}