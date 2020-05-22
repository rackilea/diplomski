import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;

public class DBServer {
    static boolean listening = true;
    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
    static List<ClientThread> users = null;

    public static void main(String[] args) {
    users= new LinkedList();
    int portNumber = 17000;
    System.out.println("Now using port number=" + portNumber);
    try {
        serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {
        System.out.println(e);
    }

    while (listening) {
        try {
            System.out.println("Number of users connected: " + users.size());
            clientSocket = serverSocket.accept();
            System.out.println("Someone just joined.");
            ClientThread ct= new ClientThread(clientSocket);
            users.add(ct);
            ct.start();
        }catch (IOException e) {
            System.out.println(e);
        }
    }
    }
}