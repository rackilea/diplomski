private void ensureBluetoothDiscoverability() {
    try {
        IBluetooth mBtService = getIBluetooth();
        Log.d("TESTE", "Ensuring bluetoot is discoverable");
        if(mBtService.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Log.e("TESTE", "Device was not in discoverable mode");
            try {
                mBtService.setDiscoverableTimeout(100);
                // mBtService.setScanMode(BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE, 1000);
            } catch(Exception e) {
                Log.e("TESTE", "Error setting bt discoverable",e);
            }
            Log.i("TESTE", "Device must be discoverable");
        } else {
            Log.e("TESTE", "Device already discoverable");
        }
    } catch(Exception e) {
        Log.e("TESTE", "Error ensuring BT discoverability", e);
    }    
}