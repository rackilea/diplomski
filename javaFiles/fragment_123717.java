try {
    System.out.println("Waiting for client........");
    ServerSocket serverSocket = new ServerSocket(8002);
    while(true){
    Socket client = serverSocket.accept();
    System.out.println("Connection Accepted......");
    ...//
   }