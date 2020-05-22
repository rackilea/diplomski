public class Server {

    static final int PORT = 8005;
    static final int QUEUE = 50;

    public Server() {
        // create serverSocket once for all connections
        try (ServerSocket serverSocket = new ServerSocket(PORT, QUEUE)) {
            while (true) {
                // accept a client connection, not in a try-with-resources so this will have to be explicitly closed
                final Socket socket = serverSocket.accept();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // limit scope of input/output to where they're actually used
                        try (DataInputStream input = new DataInputStream(socket.getInputStream());
                                DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
                            output.writeUTF("Hey, this is the server!");
                            output.flush();
                            System.out.println(input.readUTF());
                        } catch (IOException e) {
                            System.out.println();
                            e.printStackTrace();
                        }

                        // implicitly close socket when done with it
                        try {
                            socket.close();
                        } catch (IOException e) {
                            System.out.println();
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}