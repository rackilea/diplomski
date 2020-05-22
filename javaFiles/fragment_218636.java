Socket socket = new Socket();
// Configure socket here
socket.connect(new InetSocketAddress(serverAddr, portNumber), 3000);
if (! socket.isConnected()) {
    // Error handling
} else {
    // Use socket
}