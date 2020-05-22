public static void updateOrSendNotification(Context context, String[] messages) {
    NotificationManager notificationManager = (NotificationManager)
            context.getSystemService(Context.NOTIFICATION_SERVICE);


    int count = messages.length;
    if (messages.length == 0) {

        notificationManager.cancel(NOTIFICATION_ID);
        return;
    }


    //Intent to be launched on notification click
    Intent intent = new Intent(Intent.ACTION_VIEW,
            null,
            context, MainActivity.class);

    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);


    int requestID = (int) System.currentTimeMillis();
    PendingIntent contentIntent = PendingIntent.getActivity(context, requestID,
            intent, PendingIntent.FLAG_UPDATE_CURRENT);

    String ticker = context.getString(R.string.new_notification_ticker);

    NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(context);

    String contentTitle = context.getString(R.string.notification_text_style_title, messages.length);

    mBuilder.setSmallIcon(R.drawable.ic_stat_notification)
            .setTicker(ticker)                      // the thicker is the message that appears on the status bar when the notification first appears
            .setDefaults(Notification.DEFAULT_ALL)  // use defaults for various notification settings
            .setContentIntent(contentIntent)        // intent used on click
            .setAutoCancel(true)                    // if you want the notification to be dismissed when clicked
            .setOnlyAlertOnce(true); // don't play any sound or flash light if since we're updating


    NotificationCompat.Style style;
    if (count > 1) {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        style = inboxStyle;

        mBuilder.setContentTitle(contentTitle);

        for (String r : messages) {
            inboxStyle.addLine(r);
        }
    } else {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        style = bigTextStyle;

        bigTextStyle.setBigContentTitle(messages[0].substring(0, 10).concat(" ..."));
        bigTextStyle.bigText(messages[0]);
    }

    mBuilder.setStyle(style);


    notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
}