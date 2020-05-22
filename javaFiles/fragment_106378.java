import java.net.*;
import java.nio.channels.*;


public class MyNioServer {
  public static void main(String[] params) throws Exception {
    final ServerSocketChannel serverChannel = ServerSocketChannel.open();
    serverChannel.configureBlocking(true);
    serverChannel.socket().bind(new InetSocketAddress("localhost", 12345));
    System.out.println("Listening for incoming connections");
    final SocketChannel clientChannel = serverChannel.accept();
    System.out.println("Accepted connection: " + clientChannel);


    final Selector selector = Selector.open();
    clientChannel.configureBlocking(false);
    final SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_CONNECT);
    System.out.println("Selecting...");
    System.out.println(selector.select());
    System.out.println(selector.selectedKeys().size());
    System.out.println(clientKey.readyOps());
  }
}