public class SocketSingleton {


private static Socket socket;

public static void setSocket(Socket _socket){
    SocketSingleton.socket=_socket;
}

public static Socket getSocket(){
    return SocketSingleton.socket;
}