class T {
   T(Activity activity, S s) {}
}

class Test {
  @Mock Activity activity;
  @Mock S mockS;
  injector = Guice.createInjector(new AbstractModule() {
     @Override protected void configure() {
        bind(Activity.class).toInstance(activity);
        bind(S.class).toInstance(mockS);
     }}
  );
  T t = injector.getInstance(T.class);
}