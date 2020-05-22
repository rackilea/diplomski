public class PocWebApp extends GuiceServletContextListener {

@Inject
PersistService ps;

@Override
protected Injector getInjector() {
    Injector injector = Guice.createInjector(new ServletModule() {

        @Override
        protected void configureServlets() {
            install(new JpaPersistModule("DesktopPU"));
            serve("/socket/main/").with(MainSocket.class);
        }

    });
    injector.injectMembers(this);
    return injector;
}

@Override
public void contextInitialized(ServletContextEvent servletContextEvent) {
    super.contextInitialized(servletContextEvent);
    ps.start();
}
}