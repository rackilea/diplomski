@ServerEndpoint("/chat")
public class ChatEndpoint {

    private static final Set<Session> sessions = 
            Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        String username = session.getUserPrincipal().getName();
        welcomeUser(session, username);
    }

    ...

}