@ServerEndpoint("/actions")
public class DeviceWebSocketServer {

    private static AtomicReference<Set<Session>> sessionsRef = 
            new AtomicReference<>(HashSet.empty());

    @OnOpen
    public void open(Session session) {
        sessionsRef.updateAndGet(sessions -> sessions.add(session));
    }

    @OnClose
    public void close(Session session) {
        sessionsRef.updateAndGet(sessions -> sessions.remove(session));
    }

}