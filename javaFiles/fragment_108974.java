@OnMessage
public void message(final String message, final javax.websocket.Session session) throws IOException {
    for (final Session s : session.getOpenSessions()) {
        final Basic endpoint = s.getBasicRemote();
        endpoint.sendText(message);
    }
}