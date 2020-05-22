import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient implements Runnable {

  Socket socket;
  PrintWriter out;
  BufferedReader in;

  public MyClient() throws UnknownHostException, IOException {
  }

  @Override
  public void run() {
    int nbrTry = 0;
    while (true) {
      try {
        // Get a socket
        socket = new Socket(InetAddress.getByName("localhost"), 15243);

        // Wait till you can read from socket.
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String inputLine = in.readLine();
        //inputLine contains the text '[Server] I'll wait for the client'. means that server is waiting for us and we should respond.

        // Write to socket
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("[Client] Hello " + nbrTry + " !! ");

        // Let user know you wrote to socket
        System.out.println("[Client] Hello " + nbrTry++ + " !! ");

      } catch (UnknownHostException ex) {
      } catch (IOException ex) {
      }
    }
  }
}