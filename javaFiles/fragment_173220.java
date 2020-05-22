public static boolean isPlugged(Context context) {
boolean isPlugged= false;
Intent intent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
isPlugged = plugged == BatteryManager.BATTERY_PLUGGED_AC || plugged == BatteryManager.BATTERY_PLUGGED_USB;
if (VERSION.SDK_INT > VERSION_CODES.JELLY_BEAN) {
    isPlugged = isPlugged || plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS;
}
return isPlugged;
}