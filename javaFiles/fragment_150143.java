@Singleton
public class JestClientProvider implements Provider<JestClient> {

    private final JestClient client;

    @Inject
    public JestClientProvider(final Configuration configuration, final ApplicationLifecycle lifecycle) {
        // Read the configuration.
        // Do things on the start of the application.

        ...

        client = jestFactory.getObject();

        lifecycle.addStopHook(() -> {
            // Do things on the stop of the application.
            // Close the connections and so on. 
        })
    }

    @Override
    public JestClient get() {
        return client;
    }
}