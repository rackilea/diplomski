private void startSearching() {
        Log.i("Log", "in the start searching method");
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        BluetoothDemo.this.registerReceiver(myReceiver, intentFilter);
        bluetoothAdapter.startDiscovery();
    }