//Connect to NXT
    public boolean connectToNXT() {         
        // get the BluetoothDevice of the NXT
        BluetoothDevice nxt = localAdapter.getRemoteDevice(nxtMac);
        //Try to connect to the nxt
        try {
            nxtSocket = nxt.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            nxtSocket.connect();
            //Get the Data stream
            nxtDos = new DataOutputStream(nxtSocket.getOutputStream());
            success = true;
        } catch (IOException e) {
            Log.d("Bluetooth", "Err: Device not found or cannot connect");
            success = false;
        }
        return success;
    }