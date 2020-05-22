Uri alertSound = Uri.parse("android.resource://" + ctx.getPackageName() + "/raw/page_the_doctor");

        //CLICK ON NOTIFICATION
        Intent notificationIntent = new Intent(ctx, PushNotificationActions.class).setAction(ACCEPT_EXAM).putExtra("visitId", visitId).putExtra("link", link);
        PendingIntent clickIntent = PendingIntent.getBroadcast(ctx, Integer.parseInt(visitId), notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(ctx)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.telemed_logo)
                .setContentTitle("TELEMED PATIENT READY")
                .setContentText(notification)
                .setDefaults( Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)
                .setSound( alertSound )
                .setPriority(Notification.PRIORITY_MAX)
                .setContentIntent(clickIntent)
                .setAutoCancel(true);

        //Accept intent
        Intent acceptExam = new Intent(ctx, PushNotificationActions.class).setAction(ACCEPT_EXAM).putExtra("visitId", visitId).putExtra("link", link);
        PendingIntent pendingAcceptIntent = PendingIntent.getBroadcast(ctx, Integer.parseInt(visitId), acceptExam, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.addAction(R.drawable.accept_action_24dp, "ACCEPT", pendingAcceptIntent);

        //Dismiss intent
        Intent dismissExam = new Intent(ctx, PushNotificationActions.class).setAction(DISMISS_EXAM).putExtra("visitId", visitId).putExtra("link", link);
        PendingIntent pendingDismissIntent = PendingIntent.getBroadcast(ctx, Integer.parseInt(visitId), dismissExam, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.addAction(R.drawable.dismiss_action_24dp, "DISMISS", pendingDismissIntent);

        Notification noti = notificationBuilder.build();
        noti.flags |= Notification.FLAG_AUTO_CANCEL | Notification.FLAG_SHOW_LIGHTS;

        NotificationManager mNotificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Integer.parseInt(visitId), noti);