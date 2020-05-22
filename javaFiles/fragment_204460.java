private ArrayList<BluetoothDevice> mDevices = new ArrayList<BluetoothDevice>();

private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
    public void onReceive(Context context, final Intent intent) {
        final BluetoothDevice device = intent
            .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        String action = intent.getAction();
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            // Add the recently discovered device in a list
            mDevices.add(bluetoothDevice);
            mDeviceList.add(bluetoothDevice.getName() + "\n"
                + bluetoothDevice.getAddress());
            listView.setAdapter(new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, mDeviceList));
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id){
                String devicep=listView.getAdapter().getItem(pos).toString();
                Log.i("device",device);
                // Get the BluetoothDevice corresponding to the clicked item
                pairDevice(mDevices.get(position));
            }
        });
    }
};