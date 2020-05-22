if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        builder.setChannelId("YOUR_PACKAGE_NAME");
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel(
                "YOUR_PACKAGE_NAME",
                "YOUR_APP_NAME",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }