import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable {

  ServerSocket server;

  public MyServer() throws IOException {
    server = new ServerSocket(15243, 0, InetAddress.getByName("localhost"));
  }

  @Override
  public void run() {
    while (true) {
      try {
        // Get a client.
        Socket client = server.accept();

        // Write to client to tell him you are waiting.
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("[Server] I'll wait for the client");
        // Let user know something is happening.
        System.out.println("[Server] I'll wait for the client");

        // Read from client.
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String inputLine = in.readLine();

        // Write answer back to client.
        out.println("[Server] Answering : " + inputLine);

        // Let user know what it sent to client.
        System.out.println("[Server] Answering : " + inputLine);

        in.close();
        out.close();
        client.close();
      } catch (Exception e) {

      }
    }
  }
}