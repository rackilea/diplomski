import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

public Client() {
    int port = 81;
    int x = 0;
    try {

        Socket socket = new Socket(InetAddress.getLocalHost(), port);
        // use auto flush to send the data immediately to the server
        PrintWriter oos = new PrintWriter(socket.getOutputStream(), true);

        for (int i = 0; i < 3; i++) {
            x++;
            oos.println(x);
            System.out.println("Client: " + x);
        }
        oos.close();
        socket.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}