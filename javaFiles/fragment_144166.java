import java.net.*;
import java.util.concurrent.*;

public class CoordinateServer {
  public static void main(String... argv) throws Exception {
    // 'port' is known to the server and the client
    int port = Integer.valueOf(argv[0]);
    ServerSocket ss = new ServerSocket(port);

    // You should decide what the best type of service is here
    ExecutorService es = Executors.newCachedThreadPool ();

    // How will you decide to shut the server down?
    while (true) {
      // Blocks until a client connects, returns the new socket 
      // to use to talk to the client
      Socket s = ss.accept ();

      // CoordinateOutputter is a class that implements Runnable 
      // and sends co-ordinates to a given socket; it's also
      // responsible for cleaning up the socket and any other
      // resources when the client leaves
      es.submit(new CoordinateOutputter(s));
    }
  }
}