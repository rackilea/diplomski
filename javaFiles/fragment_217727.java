import java.io.IOException;
    import java.io.InputStream;
    import java.util.Properties;

    import lombok.Data;

    @Data
    public class Config implements IConfig{
        private final  String PROPERTIES_FILE = "envs.properties";
        private final  String ENVIRONMENT = "testEnvironment";  
        private String env;

        public void init(){
            try(InputStream is = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)){
                Properties props = new Properties();
                props.load(is);
                env = props.getProperty(ENVIRONMENT);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read properties file due to IO issues");
            }
        }
    }