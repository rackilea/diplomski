public class MainActivity extends BluetoothActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public int myNbrClientMax() {
        return 7;
    }

    @Override
    public void onBluetoothDeviceFound(BluetoothDevice bluetoothDevice) {

    }

    @Override
    public void onClientConnectionSuccess() {

    }

    @Override
    public void onClientConnectionFail() {

    }

    @Override
    public void onServeurConnectionSuccess() {

    }

    @Override
    public void onServeurConnectionFail() {

    }

    @Override
    public void onBluetoothStartDiscovery() {

    }

    @Override
    public void onBluetoothCommunicator(String s) {

    }

    @Override
    public void onBluetoothNotAviable() {

    }
}