import java.net.Socket;
public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("%%%%.%%%%%.dk", PORT NUMBER);
            socket.setReceiveBufferSize(2048);
            socket.setKeepAlive(true);
            System.out.println("socket " + socket.isConnected());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }
}