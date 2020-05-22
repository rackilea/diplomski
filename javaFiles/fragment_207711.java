// com.softcase.citasmanager.websocket.WsCita
@ServerEndpoint
public class WsCita{

    // there is no need to declare the session as attribute
    // private Session session;

    // ApplicatedScoped so always defined
    @Inject
    private MySessionHandler handler;

    @OnOpen
    public void open(Session session){
        handler.addSession(session);    // "Aye cap'tain, reporting from duty!"
        // your stuff
    }

    @OnClose
    public void close(Session session, CloseReason closeReason){
        handler.removeSession(session); // "Cya cap'tain, that's all for today!"
        // your stuff
    }

    // your OnMessage and other stuff here
}