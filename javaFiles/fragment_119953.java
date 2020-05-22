public class PropertyLoader {

        private Properties appProperties;

    /** The instance. */
    private static PropertyLoader inst = null;

    static{
        inst = new PropertyLoader();
    }

    /**
     * Instantiates a new property data loader.
     */
    private PropertyLoader() {
            try
            {
                appProperties = new Properties();
                appProperties.load(this.getClass().getClassLoader().getResourceAsStream("app.properties"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
    }

    public static PropertyLoader getInstance() {
        return inst;
    }


    public String getPropertyAPP(String key) {
        return appProperties.getProperty(key);
    }
}