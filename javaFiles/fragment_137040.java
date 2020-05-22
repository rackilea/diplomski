public static void main(String []args) throw Exception{
    ServerSocket serverSocket = new ServerSocket(1201);
    List<Socket> clients = new ArrayList<Socket>();

    while(true) {
        Socket client = serverSocket.accept();
        clients.add(client);
        new Thread(new Runnable(){
           public void run(){
              //Handle socket here
           }
        }).start();
    }
}