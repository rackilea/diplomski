// I believe it should be @ApplicationScoped
public class SessionProducer {
    private ThreadLocal<Session> currentSession;
    @Produces Session makeSession() {
        return currentSession.get();
    }
    public ThreadLocal<Session> getCurrentSessionThreadLocal() {
        return currentSession;
    }
}