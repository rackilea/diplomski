/**
 * Provides social api component injection.
 */
public class MySocialApiModule extends SocialApiGuiceModule {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.shindig.social.core.config.SocialApiGuiceModule#configure()
     */
    @Override
    protected void configure(){
        this.bind(ParameterFetcher.class).annotatedWith(Names.named("DataServiceServlet")).to(DataServiceServletFetcher.class);
        this.bind(Boolean.class).annotatedWith(Names.named(AnonymousAuthenticationHandler.ALLOW_UNAUTHENTICATED)).toInstance(Boolean.TRUE);
        this.bind(XStreamConfiguration.class).to(XStream081Configuration.class);
        this.bind(BeanConverter.class).annotatedWith(Names.named("shindig.bean.converter.xml")).to(BeanXStreamConverter.class);
        this.bind(BeanConverter.class).annotatedWith(Names.named("shindig.bean.converter.json")).to(BeanJsonConverter.class);
        this.bind(BeanConverter.class).annotatedWith(Names.named("shindig.bean.converter.atom")).to(BeanXStreamAtomConverter.class);
        this.bind(new TypeLiteral<List<AuthenticationHandler>>(){}).toProvider(AuthenticationHandlerProvider.class);
        final Multibinder<Object> handlerBinder = Multibinder.newSetBinder(this.binder(), Object.class, Names.named("org.apache.shindig.handlers"));
        for (final Class handler : this.getHandlers()) {
            handlerBinder.addBinding().toInstance(handler);
        }
        this.bind(OAuthDataStore.class).to(MyOAuthDataStore.class);
    }

    /**
     * Hook to provide a Set of request handlers. Subclasses may override to add
     * or replace additional handlers.
     */
    @Override
    protected Set<Class<?>> getHandlers(){
        return ImmutableSet.<Class<?>> of(ActivityHandler.class, AppDataHandler.class, MyPersonHandler.class, MessageHandler.class, MyHandler.class, ACLHandler.class);
    }
}