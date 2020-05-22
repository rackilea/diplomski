@Override
protected void configure() {
    bindFactory(SFFactory.class)
            .to(Session.class)
            .in(RequestScoped.class);
}