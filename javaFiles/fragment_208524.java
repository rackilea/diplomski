public class ntfi {

public void Send_notifi(Context context, String Title, String Content, int Icon) {
    NotificationCompat.Builder notifi_Builder = new NotificationCompat.Builder(context)
            .setSmallIcon(Icon)
            .setContentTitle(Title)
            .setContentText(Content);

    Intent resultIntent = new Intent(context, MainActivity.class);

    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
    stackBuilder.addParentStack(WordbringMainActivity.class);
    stackBuilder.addNextIntent(resultIntent);

    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    notifi_Builder.setContentIntent(resultPendingIntent);

    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(0, notifi_Builder.build());
  }