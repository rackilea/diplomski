@Override
protected void configure() {
    bindFactory(SessionFactoryFactory.class)
            .to(SessionFactory.class)
            .in(Singleton.class);
    bindFactory(SFFactory.class)
            .to(Session.class)
            .in(RequestScoped.class);
}