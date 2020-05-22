Intent pedometerIntent = new Intent();
pedometerIntent.setComponent(new ComponentName(this, Pedometer.class));
pedometerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
        pedometerIntent, 0);

CharSequence text = getText(R.string.app_name);
Notification notification = new Notification.Builder(this)
        .setSmallIcon(R.drawable.ic_notification)
        .setShowWhen(true)
        .setContentTitle(text)
        .setContentText(getText(R.string.notification_subtitle))
        .setContentIntent(contentIntent)
        .build();

notification.flags = Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;

mNM.notify(R.string.app_name, notification);