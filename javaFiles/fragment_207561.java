public static void checkInput() 
{   
     //do something here
     serverSocket = new ServerSocket(portNumber);
     //wait for request from client.
     Socket clientSocket = serverSocket.accept();
     //
     // do your processing here

     // call checkInput method again.
     checkInput();
}