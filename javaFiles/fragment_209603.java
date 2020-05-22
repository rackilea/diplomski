private BluetoothDevice mDevice = null;
if (mDevice == null) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter != null) {
            if (mBluetoothAdapter.isEnabled()) {
                Set<BluetoothDevice> bluetoothDevices = mBluetoothAdapter
                        .getBondedDevices();
                if (bluetoothDevices != null && bluetoothDevices.size() > 0) {
                    String bondedID = SharedPreferences.getInstance(
                            getApplicationContext()
                    ).getPairedAddress();
                    if (bondedID != null) {
                        for (final BluetoothDevice device : bluetoothDevices) {
                            if (device != null
                                    && device.getAddress().equals(bondedID)) {
                                mDevice = device;
                                break;
                            }
                        }
                    }
                } else {
                    Logger.v(TAG, "There are no Bluetooth Paired devices");
                }
            }
        }
    }