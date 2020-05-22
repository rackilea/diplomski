registerReceiver(batteryChangeReceiver, new IntentFilter(
    Intent.ACTION_BATTERY_CHANGED)); // register in activity or service

public class BatteryChangeReceiver extends BroadcastReceiver {

    int scale = -1;
    int level = -1;
    int voltage = -1;
    int temp = -1;

    @Override
    public void onReceive(Context context, Intent intent) {
        level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
        voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
    }
}

unregisterReceiver(batteryChangeReceiver);//unregister in the activity or service