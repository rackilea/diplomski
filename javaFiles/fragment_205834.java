ServerSocket socket = ...
...
while (true) {
    Socket clientSocket = socket.accept();
    new Thread(new MyRunnable(clientSocket)).start();
}
...
public class MyRunnable implements Runnable {
    private Socket clientSocket;
    public MyRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    public void run() {
        while (!done) {
            // use the socket associated with this thread
        }
    }
}