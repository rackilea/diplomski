public static void main(String []args) throw Exception{
    ServerSocket serverSocket = new ServerSocket(1201);
    List<Socket> clients = new ArrayList<Socket>();

    while(true) {//continuously listening for a new connection
        Socket client = serverSocket.accept(); 
        clients.add(client); 
    }
}