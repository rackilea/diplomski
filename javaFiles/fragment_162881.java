public class ConnectTest {

static ServerSocket serverSock;
static List<Socket> acceptedSockets = Collections.synchronizedList(new ArrayList<Socket>());
static final int SERVER_PORT = 55555;

static class Server implements Runnable {
    @Override
    public void run() {
        try {
            serverSock = new ServerSocket();
            serverSock.bind(new  InetSocketAddress("127.0.0.1", 55555));
            while (true)
                { acceptedSockets.add(serverSock.accept()); }
        } catch (IOException e) { e.printStackTrace(); }
    }
}

public static void main(String[] args) throws Exception {
    new Thread(new Server()).start();

    List<Socket> clientSockets = new ArrayList<Socket>();
    // open 10 sockets to the same target address/port
    for (int i = 0; i < 10; i++) {
        Socket s = new Socket("127.0.0.1", 55555);
        System.out.println("Local address: " + s.getLocalSocketAddress() +
                "    Remote address: " + s.getRemoteSocketAddress());
        clientSockets.add(s);
    }

    // now close half
    for (Socket s : clientSockets.subList(0, 5))
            s.close();

    // now list them again
    System.out.println("\n\n Socket list after some closed:");
    for (Socket s : clientSockets) {
        if (s.isClosed()) {
            System.out.println("* Socket Closed *");
        } else {
            System.out.println("Local address: " + s.getLocalSocketAddress() +
                "    Remote address: " + s.getRemoteSocketAddress());
        }
    }
}