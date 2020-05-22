public class SocketDevice{

    private static final SocketDevice INSTANCE = new SocketDevice();

    private Socket socket;

    //Private constructor prevents instantiating and subclassing
    private SocketDevice(){ 
        // instanciates the socket ...
    }

    //Static 'instance' method
    public static SocketDevice getInstance( ) {
         return INSTANCE;
    }

    public void open(){
        // ...
        socket.open()
        // ...
    }

    public void close(){
        // ...
        socket.close()
        // ...
    }

    // ...
}