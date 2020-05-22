package examples;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketFrame;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.extensions.Frame;

@WebSocket
public class AnnotatedFramesSocket
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

    @OnWebSocketFrame
    public void onFrame(Frame frame)
    {
        System.out.printf("onFrame(%s)%n",frame);
    }
}