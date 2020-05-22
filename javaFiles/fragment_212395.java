/**
 * Initially set the BroadcastSocket to use.
 * <p>Called from the constructor to create a new DatagramSocket to use 
 * for receiving and sending broadcast data over UDP.
 * @param address
 * @param port
 */
private void initBroadcastSocket(Inet4Address address, int port){
    try {
        mBroadcastSocket = new DatagramSocket(port, address);
        mBroadcastSocket.setBroadcast(true);
        mBroadcastSocket.setSoTimeout(SOCKET_TIME_OUT);
    } catch (IOException ioe) {
        Log.e(TAG, "Exception occurred while initializing BroadcastSocket: " + ioe.toString());
    }
    if(mBroadcastSocket != null){
        Log.d(TAG, "BroadcastSocket initially set to " + mBroadcastSocket.getLocalAddress() +
                    ":" + mBroadcastSocket.getLocalPort());
    }
}