private Properties props = null;

    private MyProperties() throws IOException {

        FileInputStream propFile = new FileInputStream(FULL_PATH);
        props = new Properties(System.getProperties());
        props.load(propFile);

        RegistryManager rm = RegistryManager.singleton();
        rm.addRegistry("MyProperty", this);
    }

public static MyProperties Singelton() {
        synchronized (MyProperties.class) {
            if (theInstance == null) {
                try {
                    theInstance = new MyProperties();
                } catch (IOException e) {
                    throw new MissingResourceException("Unable to load property file \"" + FULL_PATH + "\"", MyProperties.class.getName(),
                            PROPERTIES_FILENAME);
                }
            }
        }
        return theInstance;
    }