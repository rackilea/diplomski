import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestConsumer implements Runnable {
    //this holds queue instance coming from main thread, same as requestproducer
    final ConcurrentLinkedQueue<Socket> queue;

    //constructor, initiate queue
    public RequestConsumer(
            ConcurrentLinkedQueue<Socket> queue
    ) {
        this.queue = queue;
    }

    public void run() {
        try {
            Socket socket = null;
            while (true) {
                //get head of the queue (socket instance)
                System.out.println("Waiting for new socket");
                synchronized (queue) {
                    queue.wait();
                }
                System.out.println("Acquired new socket");

                socket = queue.poll();
                try {
                    if (null != socket) {
                        //process data stream
                        String in = DataStreamUtil.parseAsciiSockStream(socket.getInputStream());
                        //close socket conection
                        socket.close();
                        //excecute database insert of processed data
                        //excecuteDbInsert(in);

                        System.out.println(in);
                    }
                } finally {
                    if (socket != null) {
                        socket.close();
                    }
                }

            }
        } catch (IOException ex) {//handle exceptions}
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}