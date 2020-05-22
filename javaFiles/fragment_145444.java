Notification ForegroundNotification(string title, string message)
{
    using (var notificationManager = NotificationManager.FromContext(ApplicationContext))
    {
        var notificationBuilder = new Notification.Builder(ApplicationContext)
                                          .SetContentTitle(title)
                                                        .SetContentText(message)
                                                        .SetSmallIcon(Resource.Drawable.ic_stat_notification_network_locked)
                                                        .SetContentIntent(pendingIntent);
        if (Build.VERSION.SdkInt >= BuildVersionCodes.O)
        {
            NotificationChannel channel;
            var channelName = ApplicationContext.PackageName;
            channel = notificationManager.GetNotificationChannel(channelName);
            if (channel == null)
            {
                channel = new NotificationChannel(channelName, channelName, NotificationImportance.Default)
                {
                    LockscreenVisibility = NotificationVisibility.Public
                };
                notificationManager.CreateNotificationChannel(channel);
            }
            channel.Dispose();
            notificationBuilder = notificationBuilder
                                              .SetChannelId(channelName);
        }
        return notificationBuilder.Build();
    }
}