class BluetoothAdapterWrapper {

    private final BluetoothAdapter bluetoothAdapter;

    BluetoothAdapterWrapper(BluetoothAdapater adapter) { 
        this.bluetoothAdapter = adatper;
    }

    public boolean isBluetoothEnabled() {
        return bluetoothAdapter.isEnabled();
    }
}