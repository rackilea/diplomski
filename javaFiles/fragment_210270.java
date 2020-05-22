while(this.isRunning) {
    Socket clientSocket = null;
    try {
        clientSocket = this.serverSocket.accept();
    } catch (IOException e) {
        //handle exception on accept client socket
    }
    if(clientSocket != null) {
        Thread workerThread = new Thread(
            new YourWorkerRunnable(clientSocket /*, remain arguments */));
        workerThread.start();  
    } 
}