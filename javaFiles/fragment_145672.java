public class ServerSend implements java.lang.Runnable {
    public Thread thread;
    public ServerSend(arg) {
        //constructor
        thread = new Thread(this);
    }
    public void run() {
        //the contents of this method are executed in their own thread
    }
}