private final static String NOTIFICATION_CHANNEL = "channel_name";
private final static String CHANNEL_DESCRIPTION = "channel_description";
public final static int NOTIFICATION_ID = 1903;

private void sendNotification(Context context, String sysModel) {

    // Intent
    Intent intentAction = new Intent(context, MainActivity.class);
    intentAction.putExtra("sysModel", sysModel);

    // Pending Intent
    PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intentAction, PendingIntent.FLAG_ONE_SHOT);

    // Notification Manager
    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);

    // Create the notification channel if android >= 8
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL, CHANNEL_DESCRIPTION, NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(channel);
    }

    // Notification builder.. Note that I added the notification channel on this constructor
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL);
    notificationBuilder.setSmallIcon(R.drawable.changer_ico)
    notificationBuilder.setContentTitle(context.getString(R.string.service_ready))
    notificationBuilder.setContentIntent(pendingIntent)
    notificationBuilder.addAction(R.drawable.ic_key_black_24dp, context.getString(R.string.turn_on), pendingIntent)
    notificationBuilder.setAutoCancel(true);

    // Notify
    notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
}