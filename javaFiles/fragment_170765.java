@Override
protected void onHandleIntent(Intent intent) {

    Context context = getApplicationContext();
    if (intent.getAction().equals(ACTION_SEND_FILE)) {
        String host = intent.getExtras().getString(EXTRAS_GROUP_OWNER_ADDRESS);
        Socket socket = new Socket();
        int port = intent.getExtras().getInt(EXTRAS_GROUP_OWNER_PORT);
        DataOutputStream stream = null;
        try {
            socket.connect((new InetSocketAddress(host, port)), SOCKET_TIMEOUT);
            stream = new DataOutputStream(socket.getOutputStream());
           stream.writeUTF("a string");
        } catch (IOException e) {
            Log.e(WiFiDirectActivity.TAG, e.getMessage());
        } finally {
            if (stream != null) {
                 try {
                    stream.close();
                 } catch (IOException e) {
                    e.printStackTrace();
                 }    
            }
            if (socket != null) {
                if (socket.isConnected()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}