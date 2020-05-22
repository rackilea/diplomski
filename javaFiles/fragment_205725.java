public class BluetoothHandler {

    private final Handler handler;
    private final BluetoothAdapter bluetoothAdapter;

    @Nullable
    private BluetoothServerSocket serverSocket;
    private BluetoothSocket bluetoothSocket;


    public BluetoothHandler(Context context) {
        final HandlerThread ht = new HandlerThread("Bluetooth Handler Thread", Thread.NORM_PRIORITY);
        ht.start(); // starting thread

        this.handler = new Handler(ht.getLooper());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            this.bluetoothAdapter = ((BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter();
        } else {
            this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
    }


    public void startBluetoothServer() {
        // execute code in our background worker thread
        this.handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord("name", "your UUID");
                    bluetoothSocket = serverSocket.accept(); // will wait as long as possible (no timeout) so there is blocking

                    // do your logic to retrieve in and out put streams to read / write data from / to your Arduino device

                }  catch (IOException ioe) {

                }
            } 
        });
    }


    @AnyThread
    public void writeData(byte[] data) {
        // remember, all network operation are to be executed in a background thread
        this.handler.post(new Runnable() {
            @Override
            public void run() {
                // write data in output stream     
            }
        });
    }


    @AnyThread
    public void readData(OnDataReadCallback callback) {
        // remember, all network operation are to be executed in a background thread
        this.handler.post(new Runnable() {
            @Override
            public void run() {
                // read data and notify via callback.
            }
        });
    }


    @AnyThread // should be call from your Activity onDestroy() to clear resources and avoid memory leaks.
    public void termainte() {
       try {
           if (serverSocket != null) {
               serverSocket.close();
           }

           if (bluetoothSocket != null) {
                bluetoothSocket.close();
           }
       } catch (IOException ioe) {

       }

        this.handler.getLooper().quit(); // will no longer be usable. Basically, this class instance is now trash.
    }


    public interface OnDataReadCallback {
        @WorkerThread // watch out if you need to update some view, user your Activity#runOnUiThread method !
        void onDataRead(byte[] data);
    }
}