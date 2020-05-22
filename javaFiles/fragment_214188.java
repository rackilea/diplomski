private List<ClientThread> clients; // or "protected static List<ClientThread> clients;"


public List<ClientThread> getClients(){
    return clients;
}
    private void startServer(){
        clients = new ArrayList<ClientThread>();
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("SERVER ON");
            System.out.println("SERVER > Waiting for connections...");


//            ACCEPT ALL CONNECTIONS
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("SERVER > New connection: " + socket.getRemoteSocketAddress());
                    ClientThread client = new ClientThread(this, socket);
                    Thread thread = new Thread(client);
                    thread.start();
                    clients.add(client);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("SERVER > Accept failed");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }