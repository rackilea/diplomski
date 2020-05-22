package example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicLong;

public class NioEchoClient {
    public static void main(String... arg) throws IOException, InterruptedException {
        NioEchoServer nes = new NioEchoServer(0); // use a free port.
        final SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", nes.getPort()));
        // send data for 2 seconds.
        long writeCount = 0;
        final AtomicLong readCount = new AtomicLong();
        long start = System.currentTimeMillis();
        long end = start + 2000;
        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                ByteBuffer bb = ByteBuffer.allocateDirect(64 * 1024);
                bb.clear();
                int read;
                try {
                    while ((read = sc.read(bb)) > 0) {
                        bb.clear();
                        readCount.addAndGet(read);
                    }
                } catch (IOException ignored) {
                }
            }
        });
        reader.start();
        ByteBuffer bb = ByteBuffer.allocateDirect(64 * 1024);
        while (end > System.currentTimeMillis()) {
            bb.clear();
            int write = sc.write(bb);
            if (write < 0)
                throw new AssertionError("Unexpected disconnection?");
            writeCount += write;
        }
        sc.shutdownOutput();
        reader.join();
        long time = System.currentTimeMillis() - start;
        System.out.printf("Wrote: %,d bytes and read: %,d bytes in %,d ms%n",
                writeCount, readCount.get(), time);
        sc.close();
        nes.close();
    }
}