public class RealClassThatNeedsClientDep {

    @Inject private HttpClient client;

    public method useClient() {
        client.doStuff(); // client was injected at instance creation by Guice
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new RealModule());
        injector.getInstance(RealClassThatNeedsClientDep.class).useClient();
    }
}