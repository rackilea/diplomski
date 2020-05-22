public class MainActivity extends Activity{
       private BluetoothAdapter mBluetoothAdapter;
       private ArrayAdapter<String> mPairedDevicesArrayAdapter;
       private ListView PairedListView;
       private BluetoothService mBluetoothService = null;

      public void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.layout);
         mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
         // Initialize ArrayAdapter for paired devices
         mPairedDevicesArrayAdapter = new ArrayAdapter<String>(this, R.layout.device_name);
         PairedListView = (ListView)findViewById(R.id.listView_paired_devices);
         PairedListView.setAdapter(mPairedDevicesArrayAdapter);
         PairedListView.setOnItemClickListener(this);
         getPairedDevices();
      }

      private void getPairedDevices(){
          // Get a set of currently paired devices
          Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
          // If there are paired devices, add each one to the ArrayAdapter
               if (pairedDevices.size() > 0) {

                   for (BluetoothDevice device : pairedDevices) {
                       // Add paired devices to ArrayAdapter
                       // ArrayAdapter will be connected to LisView
                       mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                       }
               } else {
                   String noDevices = getResources().getText(R.string.title_none_paired).toString();
                   mPairedDevicesArrayAdapter.add(noDevices);
               }


           }


    }

@Override
public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
    // Cancel discovery because it's costly and we're about to connect
    mBluetoothAdapter.cancelDiscovery();
    // Get the device MAC address, which is the last 17 chars in the View
    String info = ((TextView) v).getText().toString();
    String adress = info.substring(info.length() -17);

    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(adress);
    // Attempt to connect to the given bluetooth device in separate thread
    // Reason for this is because connecting and sending bytes are blocking calls
    mBluetoothService.connect(device);

}


public class BluetoothService {
   // Unique UUID for this application
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); 
private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    private BluetoothAdapter mBluetoothAdapter;

    public synchronized void connect(BluetoothDevice device){
        // Start ConnectThread to connect to given device
        mConnectThread = new ConnectThread(device);
        mConnectThread.start();

    }
        private class ConnectThread extends Thread {
        private final BluetoothSocket mBluetoothSocket;
        private final BluetoothDevice mBluetoothDevice;

        public ConnectThread(BluetoothDevice device){
            // Use a temporary object that is later assigned to mmSocket,
            // because mmSocket is final
            mBluetoothDevice = device;
            BluetoothSocket tmp = null;
            // Get a BluetoothSocket to connect with the given BluetoothDevice
            try{
                // MY_UUID is the app's UUID string
                tmp = device.createInsecureRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e){

            }
            mBluetoothSocket = tmp;
        }

        public void run(){
            // Because BuluetoothAdapter.discovery() is 
            // heavy weight procedure, cancel any on
            // going discovery before attempting to connect
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            mBluetoothAdapter.cancelDiscovery();
            // Connect the device through the socket. This is blocking call so it
            // will return on a successful connection or an exception

            // Make a connection to the BluetoothSocket
            try {
                // Connect the device through the socket. This is blocking call so it
                // will return on a successful connection or an exception
                mBluetoothSocket.connect();
            } catch (IOException e) {
                try {
                    // Unable to connect, close the socket and get out
                    mBluetoothSocket.close();
                    setState(STATE_CONNECTION_FAILED);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            // Reset the ConnectThread because we're done
            synchronized (BluetoothService.this) {
                mConnectThread = null; 
            }
            // Do work to manage the connection (in a separate thread)
            if(mBluetoothSocket.isConnected()){
            connected(mBluetoothSocket, mBluetoothDevice); }
        }

        public void cancel(){
        // This method will cancel an in-progress connection and close the socket
            try {
                mBluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}