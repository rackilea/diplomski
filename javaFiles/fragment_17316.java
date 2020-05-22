public class SFFactory implements Factory<Session> {

    private final SessionFactory factory;

    @Inject
    public SFFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Session provide() {
        System.out.println("--- Session Created ---");
        return factory.openSession();
    }

    @Override
    public void dispose(Session session) {
        if (session.isOpen()) {
            session.close();
        }
    }
}