public class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) {
          this.socket = socket;
    }
    public void run() {
         (...other code here.)
    }
    public void otherMethod() {
          //Signal to the thread that it needs to do something (which should then be handled in the run method)
    }
}