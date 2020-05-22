public static SocketClient handle(Client client, Socket socket) 
{
  // Verify that the socket is open
  if(socketClient==null)
        socketClient=new SocketClient(client, socket);
    else {
        if(socketClient.socket!=null) {
            try {
                socketClient.socket.close();
            } catch (Exception e)   {

            }
        }
        socketClient.socket=null;
        socketClient=new SocketClient(client,socket);
    }
    return socketClient;
}