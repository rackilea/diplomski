// main server loop
while (serverIsActive) {
    clientSocket = serverSocket.accept(); 
    // spawn new thread for each client
    ClientThread ct = new ClientThread(clientSocket);
    ct.start();
}