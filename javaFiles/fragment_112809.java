public class Globals {
    static String filePath;
    public Globals(String path) {
        this.filePath = path;
        prop = Genlib.readConfig(filePath+"config.properties"); //readConfig is a method which will read the properties file
    }
    static Properties prop;
    public static final String LOGIN_URL = prop.getProperty("loginUrl");
}