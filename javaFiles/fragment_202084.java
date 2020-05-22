final List<SocketThread> clients = new ArrayList<>();

while (isListening){
    SocketThread client = new SocketThread(server.accept()).start();
    clients.add(client);
}