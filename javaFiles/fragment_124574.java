while (true) {
    // Accept a connection
    Socket socket = servSock.accept();

    // Spin off a thread to deal with the client connection
    new SocketHandler(socket).start();
}