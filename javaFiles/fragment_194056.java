import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;

public class HttpEventProducer
{
    private final RingBuffer<HttpEvent> ringBuffer;
    private final ConcurrentHashMap concurrentHashMap;

    public HttpEventProducer(RingBuffer<HttpEvent> ringBuffer, ConcurrentHashMap concurrentHashMap)
    {
        this.ringBuffer = ringBuffer;
        this.concurrentHashMap = concurrentHashMap;
    }

    public void onData(String requestId, ByteBuffer buffer, int numRead)
    {
        long sequence = ringBuffer.next();

        try
        {
            HttpEvent event = ringBuffer.get(sequence);
            event.setBuffer(buffer);
            event.setRequestId(requestId);
            event.setNumRead(numRead);
        }
        finally
        {
            concurrentHashMap.put(requestId, "0");
            ringBuffer.publish(sequence);


        }
    }
}