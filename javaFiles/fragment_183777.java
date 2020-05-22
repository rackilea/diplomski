public class Config {
    public final static String FOO_BAR;

    static {
        InputStream stream = Config.class.getResourceAsStream("/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            // You will have to take some action here...
        }
        // What if properties was not loaded correctly... You will get null back
        FOO_BAR = properties.getProperty("foo.bar");
    }

    public static void main(String[] args) {
        System.out.format("FOO_BAR = %s", FOO_BAR);
    }
}