ServerSocket svrSock;
try{
    svrSock = new ServerSocket(5000);
} catch(IOException e){
    e.printStackTrace();
    System.exit(-1);
}
while(true){
   try {
        Socket klientSocket = svrSock.accept();
        new Thread(new ServerHandler(klientSocket));
   } catch(IOException ex) {
        ex.printStackTrace();
   }
}