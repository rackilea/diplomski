import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class AnnotatedTextSocket
{
    @OnWebSocketClose
    public void onClose(int statusCode, String reason)
    {
        System.out.printf("onClose(%d, %s)%n",statusCode,reason);
    }

    @OnWebSocketConnect
    public void onConnect(Session sess)
    {
        System.out.printf("onConnect(%s)%n",sess);
    }

    @OnWebSocketError
    public void onError(Throwable cause)
    {
        System.out.printf("onError(%s: %s)%n",cause.getClass().getSimpleName(),cause.getMessage());
        cause.printStackTrace(System.out);
    }

    @OnWebSocketMessage
    public void onText(String message)
    {
        System.out.printf("onText(%s)%n",message);
    }
}