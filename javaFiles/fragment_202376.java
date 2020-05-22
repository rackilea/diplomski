ServerSocket ss = new ServerSocket(8989);
ss.setSoTimeout(10000); // 10 seconds
Socket clientSocket;
try {
    clientSocket = ss.accept();
    // process connection from client
} catch (SocketTimeoutException ste) {
    // connection was not received,
    // do something else
}