NotificationCompat.Action action =
            new NotificationCompat.Action.Builder(
                    0, "action test", pi
            ).build();

NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.schedule)
            .addAction(action)
            .setStyle(new NotificationCompat.BigTextStyle().bigText(body))
            .setContentTitle(title)
            .setContentText(body);