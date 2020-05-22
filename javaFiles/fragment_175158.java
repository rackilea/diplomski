java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);

while(true){
    java.net.Socket socket = serverSocket.accept();
    // do something
    // If you want to handle multiple connections at a time,
    // you will have to create a Thread for each socket.
}