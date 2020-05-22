public void removeFromSessions(Session session) {
    this.getSessions().remove(session);
    session.getLoads().remove(this);
}
public void addToSessions(Session session) {
    this.getSessions().add(session);
    session.getLoads().add(this);
}