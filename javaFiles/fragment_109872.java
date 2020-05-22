public class SocketManager {
    private static SocketManager instance;
    private SocketListner listner;

    public interface SocketListner {
        void onConnectionSuccess();
        void onConnectionFailed();
    }

    public void connection(SocketListner listner) {
        this.listner = listner;
        new ConnectionTask().execute();
    }