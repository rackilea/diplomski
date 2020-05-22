public class AlarmBroadcastReceiver extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {
    showNotification(context);

}

void showNotification(Context context) {
    String CHANNEL_ID = "your_name";// The id of the channel.
    CharSequence name = context.getResources().getString(R.string.app_name);// The user-visible name of the channel.
    NotificationCompat.Builder mBuilder;
    Intent notificationIntent = new Intent(context, TestActivity.class);
    Bundle bundle = new Bundle();
    notificationIntent.putExtras(bundle);
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
    PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    if (android.os.Build.VERSION.SDK_INT >= 26) {
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
        mNotificationManager.createNotificationChannel(mChannel);
        mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLights(Color.RED, 300, 300)
                .setChannelId(CHANNEL_ID)
                .setContentTitle("Title");
    } else {
        mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentTitle("Title");
    }

    mBuilder.setContentIntent(contentIntent);
    mBuilder.setContentText("Your Text");
    mBuilder.setAutoCancel(true);
    mNotificationManager.notify(1, mBuilder.build());
}