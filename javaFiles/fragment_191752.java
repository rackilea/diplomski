public static void main(String[] args) throws IOException
{
    final int PORT = 8888;
    ServerSocket server = new ServerSocket(PORT);
    System.out.println("Waiting...");
    private ArrayList<Socket> sockets = new ArrayList<Socket>();

    while(true)
    {
        Thread.sleep(100);
        Socket s = server.accept();
        System.out.println("Client connected");
        Service service = new Service(s);
        Thread t = new Thread(service);
        t.start();
        sockets.add(s);
    }