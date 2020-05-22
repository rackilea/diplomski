public class PersistenceBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bindFactory(EnglishSessionFactoryFactory.class).to(SessionFactory.class)
                .named("EnglishSessionFactory").in(Singleton.class);
        bindFactory(FrenchSessionFactoryFactory.class).to(SessionFactory.class)
                .named("FrenchSessionFactory").in(Singleton.class);
        bindFactory(SessionFactoryFactory.class)
                .proxy(true)
                .proxyForSameScope(false)
                .to(SessionFactory.class)
                .named("SessionFactory")
                .in(RequestScoped.class);
        bind(IDaoImpl.class).to(IDao.class).in(Singleton.class);
    }
}