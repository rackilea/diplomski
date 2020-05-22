Notification notification = new Notification(R.drawable.notification_icon, "Hello", System.currentTimeMillis());

CharSequence contentTitle = "My notification";  
CharSequence contentText = "Hello World!";  
Intent notificationIntent = new Intent(receiverContext, TargetActivity.class);  
PendingIntent contentIntent = PendingIntent.getActivity(receiverContext, 0, notificationIntent, 0);  

notification.setLatestEventInfo(receiverContext, contentTitle, contentText, contentIntent);  

private static final int notificationID = 1;

mNotificationManager.notify(notificationID, notification);