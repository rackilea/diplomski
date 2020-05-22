bluetoothManager = (BluetoothManager)      getSystemService(Context.BLUETOOTH_SERVICE);


    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    bluetoothAdapter.cancelDiscovery();

               bluetoothAdapter.getProfileProxy(this, listener, BluetoothProfile.HEADSET);

public final BluetoothProfile.ServiceListener listener = new  BluetoothProfile.ServiceListener() {
    @Override

    public void onServiceConnected(int i, final BluetoothProfile      bluetoothProfile) {



        final TextView txt = (TextView) findViewById(R.id.textView);


       List<BluetoothDevice> b = bluetoothProfile.getConnectedDevices();




        StringBuilder stringBuilder = new StringBuilder();

        for(BluetoothDevice getConnectedDevice : b){

            stringBuilder.append(getConnectedDevice.getName());


        }


    txt.setText(stringBuilder); 


    }

    @Override
    public void onServiceDisconnected(int i) {
        final TextView txt = (TextView) findViewById(R.id.textView);

        txt.setText(String.valueOf(i));
    }
};