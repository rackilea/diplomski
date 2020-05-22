public double batteryLevel(Context context){

    Intent batteryIntent = context.getApplicationContext().registerReceiver(null,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    int rawlevel = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
    double scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
    double level = -1;
    if (rawlevel >= 0 && scale > 0) {
        level = rawlevel / scale;
    }
    return level;    //This will return the value in range of 0.0-1.0
}