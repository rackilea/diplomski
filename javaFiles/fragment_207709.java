// @ApplicationScope
@ServerEndpoint("/item")
public class ws{   
    // something like
    private static final Set<javax.websocket.Session> ALL_SESSIONS = new HashSet<>();

    // ...
}