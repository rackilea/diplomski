public class BluetoothLostReceiver extends BroadcastReceiver {

    MainActivity main = null;

    public void setMainActivity(MainActivity main)
    {
        this.main = main;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if(BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(intent.getAction()) && Global.tryBluetoothReconnect)
        {
            if(Global.PosPrinterDeviceName != null && !Global.PosPrinterDeviceName.equals(""))
                main.connectPrinter(Global.PosPrinterDeviceName);
        }else
        {
            Global.tryBluetoothReconnect = true;
        }
    }
}