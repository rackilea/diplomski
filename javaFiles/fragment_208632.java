public class Constants {
    private static final String CONSTANT1 = System.getProperty("my.system.property");
    private static final int CONSTANT2 = Integer.valueOf(System.getProperty("my.system.property"));
    private static final String CONSTANT3;
    private static final String CONSTANT4;

    static {
        try {
            final Properties props = new Properties();
            props.load(
                new FileInputStream(
                        System.getProperty("app.properties.url", "app.properties")));

            CONSTANT3 = props.getProperty("my.constant.3");
            CONSTANT4 = props.getProperty("my.constant.3");
        } catch (IOException e) {
            throw new IllegalStateException("Unable to initialize constants", e);
        }
    }
}