private void showNotification() {
    Log.i(TAG, "showNotification called...");
    final Intent notificationIntent = new Intent(this, UpdateApplicationActivity.class);
    notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    final PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

    final Notification notification = new Notification(R.drawable.htc_notification, getString(R.string.UpdateCheck_update_available), System.currentTimeMillis());
    notification.defaults |= Notification.DEFAULT_ALL;
    notification.flags |= Notification.FLAG_ONLY_ALERT_ONCE | Notification.FLAG_SHOW_LIGHTS | Notification.FLAG_AUTO_CANCEL;
    notification.setLatestEventInfo(this, getString(R.string.UpdateCheck_notification_title), getString(R.string.UpdateCheck_notification_message), contentIntent);

    // Notifying the user about the new update.
    if (notificationManager != null) {
        notificationManager.notify(APP_UPDATE_NOTIFICATION, notification);
    }
}