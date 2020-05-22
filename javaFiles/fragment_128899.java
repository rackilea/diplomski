UUID SERIAL_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

BluetoothSocket socket = null; 

class UserInterface extends Thread {
    BluetoothDevice bdDevice;
    public UserInterface() {
        bdDevice = your pair device;

    }

    @Override
    public void run() {
        Looper.prepare();
        try {

            BluetoothDevice device = bluetoothAdapter.getRemoteDevice(bdDevice.getAddress());

            if (socket != null && socket.isConnected()) {
                is1.close();
                os1.close();
                socket.close();

            }
            try {
                socket = device.createInsecureRfcommSocketToServiceRecord(SERIAL_UUID);
            } catch (Exception e) {
                Log.e("", "Error creating socket");
            }
            if (bluetoothAdapter.isDiscovering()) {
                bluetoothAdapter.cancelDiscovery();
            }


            try {
                socket.connect();
                Log.e("", "Connected Rfcomm");

            } catch (IOException e) {
                Log.e("", e.getMessage());
                try {
                    Log.e("", "trying fallback...");

                    socket = device.createInsecureRfcommSocketToServiceRecord(SERIAL_UUID);
                    socket.connect();
                    Log.e("", "Connected serial UDID");

                } catch (Exception e2) {
                    Log.e("", "Couldn't establish Bluetooth connection!");
                }
            }


            if (socket.isConnected()) {
                dismissProgressDialog();
               //code after socket connect

            } else {
                dismissProgressDialog();
                showProgressDialogToast("Please restart polaroid bluetooth");
                closeSocket();
                Log.i("TAG", "Socket Disconnected");
            }

            Log.i("Log", "Removed" + bdDevice.getName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.i("Log", "Under Catch of thread");
            e.printStackTrace();
            dismissProgressDialog();
        }
    }
}