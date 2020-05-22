package example.nio;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioEchoServer implements Runnable, Closeable {
    private final ExecutorService service = Executors.newCachedThreadPool();
    private final ServerSocketChannel ssc;
    private volatile boolean closed = false;

    public NioEchoServer(int port) throws IOException {
        ssc = ServerSocketChannel.open();
        ssc.socket().setReuseAddress(true);
        ssc.bind(new InetSocketAddress(port));
        service.submit(this);
    }

    @Override
    public void run() {
        try {
            while (!closed) {
                SocketChannel sc = ssc.accept();
                service.submit(new EchoHandler(sc));
            }
        } catch (IOException e) {
            if (!closed)
                e.printStackTrace();
        } finally {
            closeQuietly(ssc);
        }
    }

    @Override
    public void close() throws IOException {
        closed = true;
        service.shutdownNow();
        closeQuietly(ssc);
    }

    static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) closeable.close();
        } catch (IOException ignored) {
        }
    }

    public int getPort() {
        return ssc.socket().getLocalPort();
    }

    static class EchoHandler implements Runnable {
        private final SocketChannel sc;

        public EchoHandler(SocketChannel sc) {
            this.sc = sc;
        }

        @Override
        public void run() {
            ByteBuffer bb = ByteBuffer.allocateDirect(64 * 1024);
            try {
                while (!Thread.interrupted() && sc.read(bb) > 0) {
                    int len = bb.position();
                    bb.flip();
                    while (bb.remaining() > 0)
                       sc.write(bb);
                    // write everything a second time.
                    bb.position(0);
                    bb.limit(len);
                    while (bb.remaining() > 0)
                        sc.write(bb);

                    bb.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Server disconnected");
                closeQuietly(sc);
            }
        }
    }
}