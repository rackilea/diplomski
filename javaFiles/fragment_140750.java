public class FrenchSessionFactoryFactory implements Factory<SessionFactory> {
    @Override
    public SessionFactory provide() {
        ...
    }
    @Override
    public void dispose(SessionFactory t) {}    
}