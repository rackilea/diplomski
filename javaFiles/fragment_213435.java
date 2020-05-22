public class Config {
    private static Config myInstance;

    private Config() {
        // Load the properties
    }

    public static getInstance() {
        if (myInstance == null) {
            myInstance = new Config();
        }

        return myInstance;
    }

    public String getConfigPropertyBla()

    ...
}