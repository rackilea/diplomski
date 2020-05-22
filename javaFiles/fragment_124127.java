private ServiceConnection connection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        BluetoothActivity.this.onServiceConnected(name, (BluetoothService.BluetoothBinder) binder);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        BluetoothActivity.this.onServiceDisconnected(name);
    }
};

protected void onServiceConnected(ComponentName name, BluetoothService.BluetoothBinder binder){
    bluetoothService = binder.getService();
}

protected void onServiceDisconnected(ComponentName name){
    bluetoothService = null;
}