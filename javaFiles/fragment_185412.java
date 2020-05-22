private String createNotificationChannel(Context context, Boolean audio) {

    String channelId = "channelId" + Boolean.toString(audio); // Here should be an unique id

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CharSequence name = "channel_name";
        String description = "channel_description";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(channelId, name, importance);
        channel.setDescription(description);

        // Here the condition
        if(!audio) channel.setSound(null, null);

        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
        return channelId;
    }
    return null;
}