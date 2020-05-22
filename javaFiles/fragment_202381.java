protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode != REQUEST_DISCOVERY) {
Log.d("Debug", ">>intent REQUEST_DISCOVERY failed!");
return;
}
if (resultCode != Activity.RESULT_OK) {
Log.d("Debug", ">>intent RESULT_OK failed!");
return;
}
Log.d("Debug", ">>onActivityResult!");
final BluetoothDevice device = data.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

Log.d(device.getName(), "Name of Selected Bluetoothdevice");


new Thread () {
    public void run() {
    //call connect function with device argument
    connect(device);
    };
}.start();
}