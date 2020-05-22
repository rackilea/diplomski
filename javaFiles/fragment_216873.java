public class BatInfoReceiver extends BroadcastReceiver{
 @Override
    public void onRecieve(Context arg0, Intent intent){
        int temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
        BatTemp.setText(String.valueOf(temp) + "%");

    }
}