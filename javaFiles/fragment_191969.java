NotificationManager notificationManager;
notificationManager = (NotificationManager)
    context.getSystemService(Context.NOTIFICATION_SERVICE);

Intent notificationIntent = new Intent(context,
                                       UnityPlayerActivity.class);

notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP);

PendingIntent intent = PendingIntent
    .getActivity(context, 0, notificationIntent, 0);

RemoteViews remoteView = new RemoteViews(context.getPackageName(),
                                         R.layout.notification);
remoteView.setTextViewText(R.id.title, title);
remoteView.setTextViewText(R.id.message, message);
remoteView.setImageViewResource(R.id.icon, R.drawable.ic_launcher);

NotificationCompat.Builder mBuilder =
    new NotificationCompat.Builder(context)
    .setSmallIcon(R.drawable.ic_launcher)
    .setContentIntent(intent);

Notification notification = mBuilder.build();
notification.contentView  = remoteView;

notificationManager.notify(0, notification);