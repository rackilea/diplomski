@OnOpen
public void onOpen(Session session) {
    if(session.getOpenSessions().size() > maxConnections) {
        session.close(new CloseReason(...));
    }
    // ...
}