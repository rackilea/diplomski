@Inject
private javax.inject.Provider<Session> session;

@Override
public void saveEvent(Event event) {
    Session s = session.get();
    Transaction tx = s.beginTransaction();