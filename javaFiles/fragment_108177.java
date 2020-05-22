import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestProducer implements Runnable {
    //this holds queue instance coming from main thread
    final ConcurrentLinkedQueue<Socket> queue;

    //constructor, initiate queue
    public RequestProducer(
            ConcurrentLinkedQueue<Socket> queue
    ) {
        this.queue = queue;
    }

    public void run() {
        try {
            //create serversocket instance on port 19029
            ServerSocket serverSocket = new ServerSocket(19029);
            while (true) {
                try {
                    //keep accept connections
                    Socket socket = serverSocket.accept();
                    //add socket to queue
                    queue.offer(socket);
                    synchronized (queue) {
                        System.out.println("notifying");
                        queue.notify();
                    }
                } catch (ConnectException ce) {//handle exception
                } catch (SocketException e) {//handle exception
                }
            }
        } catch (IOException ex) {//handle exception}
        }

    }
}