import com.lmax.disruptor.EventHandler;

import java.nio.ByteBuffer;
import java.util.Dictionary;
import java.util.concurrent.ConcurrentHashMap;

public class HttpEventHandler implements EventHandler<HttpEvent>
{
    private int id;
    private ConcurrentHashMap concurrentHashMap;

    public HttpEventHandler(int id, ConcurrentHashMap concurrentHashMap){
        this.id = id;
        this.concurrentHashMap = concurrentHashMap;

    }

    public void onEvent(HttpEvent event, long sequence, boolean endOfBatch) throws Exception
    {
        if( sequence % Runtime.getRuntime().availableProcessors()==id){


            String requestId = event.getRequestId();
            ByteBuffer buffer = event.getBuffer();
            int numRead= event.getNumRead();

            ByteBuffer responseBuffer = handleRequest(buffer, numRead);


            this.concurrentHashMap.put(requestId, responseBuffer);

        }
    }

    private ByteBuffer handleRequest(ByteBuffer buffer, int numRead) throws Exception {

        buffer.flip();
        byte[] data = new byte[numRead];
        System.arraycopy(buffer.array(), 0, data, 0, numRead);
        String request = new String(data, "US-ASCII");
        request = request.split("\n")[0].trim();


        String response = serverRequest(request);

        buffer.clear();

        buffer.put(response.getBytes());
        return  buffer;
    }

    private String serverRequest(String request) throws Exception {
        String response = "Sample Response";
        if (request.startsWith("GET")) {

            // http request parsing and response generation should be done here.    


        return  response;
    }
}