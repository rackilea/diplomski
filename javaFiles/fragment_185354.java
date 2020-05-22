import android.app.Notification;
    import android.app.NotificationManager;
    import android.app.PendingIntent;

    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;
    Context ctx;
    private  void sendNotification(Intent receivedIntent) {

      mNotificationManager = (NotificationManager)ctx.getSystemService(Context.NOTIFICATION_SERVICE);
      Intent intent = new Intent(ctx, ReceiveNotification.class);// this will open the class receiveNotification when the notification is clicked
      intent.putExtra("author", receivedIntent.getStringExtra("author"));

      PendingIntent pendingIntent = PendingIntent.getActivity(ctx, 0, intent , 0);
      NotificationCompat.Builder noti =  new NotificationCompat.Builder(ctx)
       .setSmallIcon(R.drawable.ic_launcher)     // if you want to include an icon
       .setContentTitle("your app name")
       .setStyle(new NotificationCompat.BigTextStyle()
       .bigText("By: " +  receivedIntent.getStringExtra("name")))
       .setWhen(System.currentTimeMillis())
       .setTicker("By: " +  receivedIntent.getStringExtra("name"))
       .setDefaults(Notification.DEFAULT_SOUND)
       .setContentText("your message");
       noti.setContentIntent(pendingIntent);
        mNotificationManager.notify(1, noti.build());

   }