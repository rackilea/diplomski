public class SessionManager {

    private static SessionManager instance;
    private Session currentSession; // this object holds the session data (user, host, start time, etc)

    private SessionManager(){ ... }

    public static SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }
        return instance;
    }

    public void startNewSession(User user){
        // starts a new session for the given User
    }

    public void endCurrentSession(){
        // here notify the server that the session is being closed
    }

    public Session getCurrentSession(){
        return currentSession;
    }
}