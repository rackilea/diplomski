public class Client {
    private final String host;
    private final int port;

    private boolean connected;
    private Socket socket;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        connected = true;
        socket = new Socket(host, port);

        Runnable serverInputReader = () -> {
            try (DataInputStream in = new DataInputStream(socket.getInputStream())) {
                while (connected) {
                    String data = in.readUTF();
                    System.out.println(data);
                }
            } catch (IOException e) {
                // problem connecting to server; problem wrapping stream; problem receiving data from server;
                e.printStackTrace();
            }
        };

        Runnable userInputReader = () -> {
            try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    Scanner scanner = new Scanner(System.in)) {
                while (connected) {
                    String input = scanner.nextLine();
                    out.writeUTF(input);
                }
            } catch (IOException e) {
                //problem wrapping stream; problem sending data;
                e.printStackTrace();
            }
        };

        Thread communicateThread = new Thread(serverInputReader);
        Thread userThread = new Thread(userInputReader);
        communicateThread.start();
        userThread.start();
    }

    public static void main(String[] args) throws IOException {
        new Client("localhost", 15180).start();
    }
}