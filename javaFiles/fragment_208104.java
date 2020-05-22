public class ServerSocketExample {
    private static ServerSocket server;
    private static int PORT = 5003;

    public static void main(String[] args) throws Exception {
        server = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for clients...");
            Socket s = server.accept();
            System.out.println("Client connected: " + s.getLocalAddress().getHostName());

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String request = reader.readLine();
            System.out.println("Client says ("+request.length()+"): " + request);

            System.out.println("Sending ACK response\n");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            writer.write("ACK\n");
            writer.flush();
        }
    }
}