public class DatabaseConfigSource implements ConfigSource {

    private static boolean allowInit;

    @Inject
    private ConfigParameterProvider configParameterProvider;

    @Override
    public int getOrdinal() {
        return 500;
    }

    @Override
    public String getPropertyValue(String key) {
        initIfNecessary();

        if (configParameterProvider == null) {
            return null;
        }

        return configParameterProvider.getProperty(key);
    }

    public static void allowInitialization() {
        allowInit = true;
    }

    private void initIfNecessary() {
        if (allowInit) {
            BeanProvider.injectFields(this);
        }
    }

}