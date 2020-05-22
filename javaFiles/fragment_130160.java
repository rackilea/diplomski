public class Settings extends JFrame{
    String configFilePath = "C:/path/to/settings.properties";
    Properties properties = new Properties();

    private static Settings instance;

    public static Settings getInstance(){
       if(instance==null){
           instance = new Setting();
       }
       return instance;
    }

    private Settings() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(configFilePath);
            properties.load(fis);

        } catch (FileNotFoundException e) {
            setDefaults();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}