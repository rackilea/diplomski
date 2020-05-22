public class MyProperties{
   private static MyProperties instance = null;
   private Properties prop;

   private MyProperties() {
      InputStream input = new FileInputStream("config.properties");
      // load a properties file
      prop.load(input);

   }
   public static MyProperties getInstance() {
      if(instance == null) {
         instance = new MyProperties();
      }
      return instance;
   }

   public Properties getProperty() {
       return prop;
   }
}