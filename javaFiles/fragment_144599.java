interface SocketFactory {
  public ServerSocket createSocketFor(int port);
}

class SocketFactoryImpl implements SocketFactory {
...

public class Server implements Runnable {

  public Server(int port) {
    this(port, new SocketFactoryImpl());
  }

 Server(int port, SocketFactory socketFactory) {
   ...