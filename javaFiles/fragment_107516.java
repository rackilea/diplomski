public interface BluetoothDevicesAvailable {
    void onBluetoothDeviceListChanged(List<BluetoothDevice> deviceList);
    }

    public class SomeActivity implements BluetoothDevicesAvailable {
    //... Some code

    @Override
    public void onBluetoothDeviceListChanged(List<BluetoothDevice> deviceList) {
    //Add your logic here to update UI
    }
}