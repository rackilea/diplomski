final Intent notificationSettingsIntent = new Intent();
notificationSettingsIntent
        .setAction("android.settings.APP_NOTIFICATION_SETTINGS");
notificationSettingsIntent
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    notificationSettingsIntent.putExtra(
            "android.provider.extra.APP_PACKAGE",
            activity.getPackageName());
}
else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        notificationSettingsIntent.putExtra(
                "app_package",
                activity.getPackageName());
        notificationSettingsIntent.putExtra(
                "app_uid", 
                activity.getApplicationInfo().uid);
}
activity.startActivityForResult(
        notificationSettingsIntent, 
        NOTIFICATIONS_SETTINGS_REQUEST_CODE);