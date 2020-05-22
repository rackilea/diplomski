private void generateNotification(Context context,String message){
int notificationId = 001;
// Build intent for notification content
Intent viewIntent = new Intent(context, YourActivity.class);
viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
PendingIntent viewPendingIntent =
        PendingIntent.getActivity(context, 0, viewIntent, 0);

NotificationCompat.Builder notificationBuilder =
        new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_event)
        .setContentTitle("Title")
        .setContentText(message)
        .setContentIntent(viewPendingIntent);

// Get an instance of the NotificationManager service
NotificationManagerCompat notificationManager =
        NotificationManagerCompat.from(context);

// Build the notification and issues it with notification manager.
notificationManager.notify(notificationId, notificationBuilder.build());
 }