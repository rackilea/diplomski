int port = 23982;
java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
java.net.Socket client = serverSocket.accept(); 
// blocks until there is a connection-request. So you can
// now handle your notification, because if the program reaches this part of code, 
// a client has connected, e.g.:

boolean connected = true;