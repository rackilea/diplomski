private final BroadcastReceiver foundRec = new BroadcastReceiver() {
List<BluetoothDevice> BtDevices = new ArrayList<BluetoothDevice>();
@Override
public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if (action.equals(BluetoothDevice.ACTION_FOUND)) {

        Log.e(TAG, "--- device found ---");

        BluetoothDevice dev = intent
                .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        if(!IsBtDevPresent(dev)) {
            BtDevices.add(dev);
            if (dev.getBondState() == BluetoothDevice.BOND_BONDED) {
                availableDevices.add(dev.getName() + " (paired)");
            } else {
                availableDevices.add(dev.getName());
            }
        }
    } else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_STARTED)){

        Log.d(TAG, "DISCOVERY STARTED");
        findViewById(R.id.lookup).setVisibility(View.VISIBLE);

    }
}

private boolean IsBtDevPresent(BluetoothDevice dev) {
    int size = BtDevices.size();
    for(int i = 0; i<size; i++) {
         if( BtDevices.get(i).equals(dev)) {
             return true;
         }
    }
    return false;
}