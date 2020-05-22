public class MyWebComponent
{
  private final Provider<X> theGuiceCreatedObject;
  private final SimpleScope perRequestScope;

  public MyWebComponent() {
    perRequestScope = new SimpleScope();
    Injector injector = Guice.createInjector(new AbstractModule()
    {
        @Override
        protected void configure()
        {
            install(new NonChangingModule());
            bind(Foo.class).toProvider(SimpleScope.seededKeyProvider())
                .in(perRequestScope);
            bind(Bar.class).toProvider(SimpleScope.seededKeyProvider())
                .in(perRequestScope);
        }
    });
    theGuiceCreatedObject = injector.getProvider(X.class);
  }

  // I assume methods called makeFoo and makeBar that can make
  // a Foo or Bar for a request

  // called by the web service to say "handle this request"
  public RequestResult handleRequest(DataToMakeFooAndBarWith requestData) {
    try {
      perRequestScope.enter();
      perRequestScope.seed(Foo.class, makeFoo(requestData));
      perRequestScope.seed(Bar.class, makeBar(requestData));
      return theGuiceCreatedObject.get().doTheActualRequestLogic(requestData);
    } finally {
      perRequestScope.exit();
    }
  }
}