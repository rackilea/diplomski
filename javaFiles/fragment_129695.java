// turn on the alarm
notification.sound = soundUri;
notification.flags |= Notification.FLAG_INSISTENT;
// after 30 seconds turn off the alarm
new Handler().postDelayed(
    new Runnable() {
            @Override
            public void run() {
                notification.flags ^= Notification.FLAG_INSISTENT;
                notificationManager.notify(tag, NOTIFICATION_ID,   
                    notification);
            }
    }, 30000);