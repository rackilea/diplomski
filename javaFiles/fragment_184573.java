public boolean checkWriteSettingsPermission() {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return true;
    }
    if (!Settings.System.canWrite(getContext())) {
        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
            Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE);
        return false;
    } else {
        return true;
    }
}