public class WebsocketServer {

public static final int MASK_SIZE = 4;
public static final int SINGLE_FRAME_UNMASKED = 0x81;
private ServerSocket serverSocket;
private Socket socket;

public WebsocketServer() throws IOException {
    serverSocket = new ServerSocket(2005);
    connect();
}

private void connect() throws IOException {
    System.out.println("Listening");
    socket = serverSocket.accept();
    System.out.println("Got connection");
    if(handshake()) {
         listenerThread();
    }
}