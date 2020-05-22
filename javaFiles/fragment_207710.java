// com.softcase.citasmanager.websocket.SessionHandler
@ApplicatedScoped
@Named // optional
public class MySessionHandler{

    private final Set<Session> ALL_SESSIONS;
    // or use a map if you need to identify the
    // the session by a key. This example uses Set
    // private final Map<String, Session> ALL_SESSIONS;

    public MySessionHandler(){
        ALL_SESSIONS = new HashSet<>();
    }

    // manage sessions
    public void addSession(Session session){
        this.ALL_SESSIONS.add(session);
    }

    public void removeSession(Session session){
        this.ALL_SESSIONS.remove(session);
    }

    // send messages to all instances:
    public void sendMessage(String message){
        this.ALL_SESSIONS.stream()
            // optional
            .filter(s -> s.isOpen())
            // or whatever method you want to send a message
            .forEach( s -> s.getBasicRemote().sendText(message);
    }
    // or if you want to target a specific session
    // hence my questions in comments
    public void sendMessage(String message, String target){
        this.ALL_SESSIONS..stream()
            // identity the target session
            .filter(s -> s.equals(target))
            // optional
            .filter(s -> s.isOpen())
            .forEach( s -> s.getBasicRemote().sendText(message);
    }

}