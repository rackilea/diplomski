public class GameServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ServerSocket start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        return serverSocket;
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    // This method accepts and serves the incoming requests
    public void acceptConnection(ServerSocket serverSocket) throws IOException {
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String move = in.readLine();

        System.out.println(move);

        out.println("6,1");
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        ServerSocket serverSocket = server.start(3333);
        System.out.println("Server Started");

        // The effective change you need to make
        // Loop through the incoming requests
        while(true) {
            server.acceptConnection(serverSocket);
        }
    }
}


public class GameClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void openConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        String resp = "";
        out.println(msg);
        resp = in.readLine();

        return resp;
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();

        client.openConnection("10.7.232.200", 3333);
        String response = client.sendMessage("1,2");
        System.out.println(response);
        client.stop();
    }
}