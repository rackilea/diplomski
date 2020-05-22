public class MyProvider implements Provider<String> {
    public String get() {
        System.out.println("Called MyProvider.get()");
        return "abcd";
    }
}

public class MyModule extends AbstractModule {
    protected void configure() {
        bind(String.class).toProvider(MyProvider.class).in(Singleton.class);
    }
}

Injector injector = Guice.createInjector(new MyModule());
String abcd1 = injector.getInstance(String.class);  // Prints "Called MyProvider.get()
String abcd2 = injector.getInstance(String.class);  // Prints nothing!
// Or, if you want, comment out above two lines and try the following:
Provider<String> abcdProvider = injector.getProvider(String.class);
abcdProvider.get();  // Prints "Called MyProvider.get()"
abcdProvider.get();  // Prints nothing