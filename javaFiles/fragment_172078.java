public class SimpleServer extends Thread {

public void run() {
    try {
        serverSocket = new ServerSocket(port);

          while (true) {
            Socket s = serverSocket.accept(); 
          }
    } 
    catch (IOException e) {
            e.printStackTrace();
    }
    finally {
        serverSocket = null;
    }
}
}