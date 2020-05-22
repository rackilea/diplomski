import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NewConnections {

public NewConnections() {
    acceptConnections.start();
}

Thread acceptConnections = new Thread(new Runnable() {
    public void run() {
        try {
            int port = 81;
            ServerSocket ssocket = new ServerSocket(port, 0, InetAddress.getLocalHost());
            while (true) {
                System.out.println("waiting...");
                Socket socket = ssocket.accept();
                // buffered reader to read a line at a time from client
                BufferedReader ois = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));

                String x = null;
                // read till input is available from client
                while ((x = ois.readLine()) != null) {
                    System.out.println("Server: " + x);
                }
                ois.close();
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});
}