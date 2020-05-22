public Server(int port){
    Values val = new Values();
    // Add your ServerSocket code here instead of the loop
    serversocket = new ServerSocket(port);
    System.out.println("Server started\nWaiting for clients ...");
    while(true) {
        try {
            socket=serversocket.accept();
            System.out.println("Client accepted");
            ProcessRequest pRequest = new ProcessRequest(socket, val);
            Thread t = new Thread(pRequest);
            // And so on...
        }