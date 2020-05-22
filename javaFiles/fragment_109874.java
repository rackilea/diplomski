public class YourActivity imlpements SocketListner {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
     //your code
      ..
    }
    @Override
    void onConnectionSuccess() {
        //your socket is connected
        status.setText("Connected");
    }

    @Override
    void onConnectionFailed() {
        status.setText("Disconnected");
    }
}