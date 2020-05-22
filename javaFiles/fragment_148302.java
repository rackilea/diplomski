// main or server thread
ServerSocket  serverSocket = new ServerSocket(6533);
try {
   while (!shuttingDown) {
       Socket socket = serverSocket.accept();
       // better would be to use an ExecutorService thread-pool here
       new Thread(new ConnectionHandlerRunnable(socket)).start();
   }
} finally {
   serverSocket.close();
}