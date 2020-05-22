while(numConnections < 2){
       connection = providerSocket.accept();
       Thread t = new Thread(new ConnectionHandler(connection));
       t.start();
       numConnections++;
 }