// some import
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ServerEndPoint(value = "/myEndPointPath")
public class TickEndPoint{

    @Inject
    private TickSessionHandler sessionHandler;

    @OnOpen
    public void onOpen(Session session){
        sessionHandler.addSession(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason){
         sessionHandler.removeSession(session);
    }

}