import com.lmax.disruptor.EventFactory;

public class HttpEventFactory implements EventFactory<HttpEvent>
{
    public HttpEvent newInstance()
    {
        return new HttpEvent();
    }
}