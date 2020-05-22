NotificationManager nm;
  nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);        
  CharSequence from = "VIPUL";
  CharSequence message = "Crazy About Android...";
  PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
    new Intent(), 0);
  Notification notif = new Notification(R.drawable.icon,
    "Crazy About Android...", System.currentTimeMillis());
  notif.setLatestEventInfo(context, from, message, contentIntent);
  nm.notify(1, notif);