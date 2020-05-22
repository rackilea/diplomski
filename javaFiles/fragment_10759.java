class TCPServer {

   public static void main(String argv[]) throws Exception {
         int port = 8081;
         ServerSocket waiting = new ServerSocket(port);

         while(true) {
            Socket socket = waiting.accept(); //wait until a client shows up
            new SessionHandler(socket).start();//create new handler with the socket
            //start listening again
         }
      }
}