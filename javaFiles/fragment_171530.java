// Build Notification , setOngoing keeps the notification always in status bar
mBuilder = new NotificationCompat.Builder(context, "notify_001") // Add channel ID to the constructor.
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("RandomTitle")
        .setContentText("RandomText")
        .setOngoing(true);