/**
 *
 * @param context
 * @param title  --> title to show
 * @param message --> details to show
 * @param intent --> What should happen on clicking the notification
 * @param reqCode --> unique code for the notification
 */

public void showNotification(Context context, String title, String message, Intent intent, int reqCode) {
    SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);

    PendingIntent pendingIntent = PendingIntent.getActivity(context, reqCode, intent, PendingIntent.FLAG_ONE_SHOT);
    String CHANNEL_ID = "channel_name";// The id of the channel.
    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.notification_logo)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setContentIntent(pendingIntent);
    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CharSequence name = "Channel Name";// The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
        notificationManager.createNotificationChannel(mChannel);
    }
    notificationManager.notify(reqCode, notificationBuilder.build()); // 0 is the request code, it should be unique id

    Log.d("showNotification", "showNotification: " + reqCode);
}