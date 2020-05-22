public class PropertiesHolder {
   private static final PropertiesHolder INSTANCE = new PropertiesHolder();

   private final Properties props;

   private PropertiesHolder() {
       props = load();
   }

   public static PropertiesHolder getInstance() {
       return INSTANCE;
   }

   public String getProperty(String key) {
       return props.getProperty(key);
   }

   private Properties load() {
      ...
   }
}