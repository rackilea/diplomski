NotificationManager notificationManager = 
    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    && !notificationManager.isNotificationPolicyAccessGranted()) {

    Intent intent = new Intent(
                        android.provider.Settings
                        .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

    startActivity(intent);
}