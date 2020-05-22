package server;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class Server {

public Server() throws IOException{
    Selector selector = SelectorProvider.provider().openSelector();
    ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(9000));
    ssc.configureBlocking(false);       
    ssc.register(selector, 
              SelectionKey.OP_ACCEPT);  


    while(true) {

      int readyChannels = selector.select();

      if(readyChannels == 0) continue;


      Set<SelectionKey> selectedKeys = selector.selectedKeys();

      Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

      while(keyIterator.hasNext()) {

        SelectionKey key = keyIterator.next();

        if(key.isAcceptable()) {
           System.out.println("acceptable");
           SocketChannel socketChan =  ((ServerSocketChannel)key.channel()).accept();
           socketChan.configureBlocking(false);
            socketChan.register(selector, SelectionKey.OP_READ);

        } else if (key.isConnectable()) {
            // a connection was established with a remote server.

        } else if (key.isReadable()) {
            System.out.println("Processing reading...");

            ByteBuffer buf = ByteBuffer.allocate(1024);
            int readedBytes = ((SocketChannel)key.channel()).read(buf);
            System.out.println("Readed: " + readedBytes);
            buf.flip();

            for(byte b : buf.array()) {
                System.out.print((char) b);
            }

        } else if (key.isWritable()) {
            // a channel is ready for writing
        }

        keyIterator.remove();
      }
    }
}

public static void main(String[] args) throws IOException {
    Server server = new Server();

}

}