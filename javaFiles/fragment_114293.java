private void ExpandNotificationBar(){
    if(ContextCompat.checkSelfPermission(this, Manifest.permission.EXPAND_STATUS_BAR) != PackageManager.PERMISSION_GRANTED)
        return;

    try{
        Object service = getSystemService("statusbar");
        Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
        Method expand = statusbarManager.getMethod("expandNotificationsPanel"); //<-
        expand.invoke(service);
    }
    catch (Exception e){
        Log.e("StatusBar", e.toString());
        Toast.makeText(getApplicationContext(), "Expansion Not Working", Toast.LENGTH_SHORT).show();
    }
}