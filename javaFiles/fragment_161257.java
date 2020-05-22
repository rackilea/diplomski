@TargetApi(23)
public void askPermission() {
    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:" + getPackageName()));
    startActivityForResult(intent, SYSTEM_ALERT_WINDOW_PERMISSION);
}