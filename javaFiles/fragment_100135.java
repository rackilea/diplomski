public void receiveData(BluetoothSocketWrapper socket) throws IOException{
    InputStream socketInputStream =  socket.getInputStream();
    byte[] buffer = new byte[256];
    int bytes;

    // Keep looping to listen for received messages
    while (true) {
        try {
            bytes = socketInputStream.read(buffer);            //read bytes from input buffer
            String readMessage = new String(buffer, 0, bytes);
            // Send the obtained bytes to the UI Activity via handler
            Log.i("logging", readMessage + "");
        } catch (IOException e) {
            break;
        }
    }

}