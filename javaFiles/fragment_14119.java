NotificationChannel channel = new NotificationChannel("channel01", "name", 
     NotificationManager.IMPORTANCE_HIGH);   // for heads-up notifications
channel.setDescription("description");

// Register channel with system
NotificationManager notificationManager = getSystemService(NotificationManager.class);
notificationManager.createNotificationChannel(channel);