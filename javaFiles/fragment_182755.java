mWebSocketClient = new WebSocketClient(uri,new Draft_17()) 
{
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        Log.i("Websocket", "Opened");
    }

    @Override
    public void onMessage(String s) {
        //final String message =s;

    }

    @Override
    public void onClose(int i, String s, boolean b) {
        Log.i("Websocket", "Closed " + s);
    }

    @Override
    public void onError(Exception e) {
        Log.i("Websocket", "Error " + e.getMessage());
    }
};

if (websocketEndPointUrl.indexOf("wss") == 0) 
{
    try {
        SSLContext sslContext = SSLContext.getDefault();
        mWebSocketClient.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(sslContext));
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
} 

mWebSocketClient.connect();