import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class EncryptedAsynchronousSocketChannel {
    private AsynchronousSocketChannel channel;
    public Future<Integer> read(ByteBuffer dst){
        return channel.read(dst);
    }
    public Future<Integer> write(ByteBuffer src){
        return channel.write(src);
    }
}