for (int i = 0; i < ClientSockets.size(); i++) {
    Socket pSocket = (Socket) ClientSockets.elementAt(i);

    if(ClientSocket.equals(pSocket)){
        continue;
    }
    ...