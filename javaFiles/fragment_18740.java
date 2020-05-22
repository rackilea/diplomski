@TargetApi(Build.VERSION_CODES.O)
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

public void show_Notification(){

Intent intent=new Intent(getApplicationContext(),MainActivity.class);
String CHANNEL_ID="MYCHANNEL";
NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,"name",NotificationManager.IMPORTANCE_LOW);
PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
Notification notification=new Notification.Builder(getApplicationContext(),CHANNEL_ID)
        .setContentText("Heading")
        .setContentTitle("subheading")
        .setContentIntent(pendingIntent)
        .addAction(android.R.drawable.sym_action_chat,"Title",pendingIntent)
        .setChannelId(CHANNEL_ID)
        .setSmallIcon(android.R.drawable.sym_action_chat)
        .build();

NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.createNotificationChannel(notificationChannel);
notificationManager.notify(1,notification);


 }