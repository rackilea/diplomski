public class Settings {
    public static final Configuration config;

    static {
        Configuration c = null;
        try {
            DefaultConfigurationBuilder factory = new DefaultConfigurationBuilder("config.xml");
            c = factory.getConfiguration();
        }
        catch (SomeException e) {
            // Deal with the exception
            c = null;
        }

        config = c;
    }
}