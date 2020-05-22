import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class Test
{
    public static void main(String[] args)
    {
        final AsynchronousSocketChannel out = AsynchronousSocketChannel.open();
        out.connect(new InetSocketAddress("www.google.com", 80), null,
            new CompletionHandler<Void, Void>()
            {
                @Override
                public void completed(Void result, Void attachment)
                {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.asCharBuffer().put("GET /index.html HTTP/1.1");
                    out.write(buffer, null, new CompletionHandler<Integer, Void>()
                    {
                        @Override
                        public void completed(Integer result, Void attachment)
                        {
                            // ignore the result
                        }
                            @Override
                        public void failed(Throwable t, Void attachment)
                        {
                            t.printStackTrace();
                        }
                    });
                }

                @Override
                public void failed(Throwable t, Void attachment)
                {
                    t.printStackTrace();
                }
            });
    }
}