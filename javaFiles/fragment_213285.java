public class BluetoothConnectionActivity extends Activity {

    private Button connectButton;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            connectButton = (Button) findViewById(R.id.connectButton);
            connectButton.setOnclickListener(View.onClickListener() {
                        @Override
                    public void onClick(View v) {
                           String address = "00:15:83:07:d1:14";
                   new ConnectAsyncTask(address).execute();
                    }
                    });


        }

    private class ConnectAsyncTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected void onPostExecute(Boolean isConnected) {
            Toast.makeText(getApplicationContext(), "Connecting...",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Boolean doInBackground(String... param) {
            BluetoothDevice device = BluetoothAdapter
                    .getDefaultBluetoothAdapter().getRemoteDevice(param[0]);
            try {
                BluetoothSocket mmSocket = device
                        .createRfcommSocketToServiceRecord(MY_UUID);
                mmSocket.connect();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("BluetoothConnectivity", "ERROR:" + e.getMessage());
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean isConnected) {
            if (isConnected) {
                Toast.makeText(getApplicationContext(), "Connected",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to connected",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}