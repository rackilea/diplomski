public class ClientHandler {
    private Thread receiveThread;
    private Thread sendThread;
    private boolean connected;
    private Socket clientSocket;
    private String clientName;
    private LinkedBlockingDeque<byte[]> sendQueue;

    public ClientHandler(String name, Socket s) {
        clientSocket = s;
        clientName = name;

        receiveThread = new Thread(() -> receive());
        sendThread = new Thread(() -> send());

        connected = clientSocket.isConnected();

        receiveThread.start();
        sendThread.start();
    }

    private void receive() {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            connected = false;
        }
        while (connected) {
            try {
                byte[] bytes = in.readAllBytes();
                if (bytes != null && bytes.length > 0) {
                    controller.handleReceivedPacket(clientName, bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void send() {
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            connected = false;
        }
        while (connected) {
            byte[] toSend = sendQueue.getFirst();
            if (toSend != null && toSend.length > 0) {
                try {
                    out.write(toSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void send(byte[] packet) {
        sendQueue.add(packet);
    }

    public void close() {
        connected = false;
    }
}