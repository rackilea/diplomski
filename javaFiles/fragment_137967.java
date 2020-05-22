@Named
@ApplicationScoped
public class TickSessionHandler{

    // There is no need to have a static Set, worst,
    // containers don't like it
    public Set<Session> SESSIONS;

    // let's initialize the set
    public TickSessionHandler{
        this.SESSIONS = new HashSet<>();
    }

    // ---------- sessions management
    public void addSession(Session session){
        this.SESSIONS.add(session);
    }

    public void removeSession(Sesssion session){
        this.SESSIONS.remove(session);
    }

    // ---------- Listen to the timer
    public void onTick(@Observes TickEvent event){

        // if required, get the event attribute
        // and proceed

        // your request:
        this.SESSIONS.forEach(session -> {
            session.getBasicRemote().sendText("hello");
        });
    }

}