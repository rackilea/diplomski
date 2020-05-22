@Component
@ConfigurationProperties(prefix="spring.datasource")
public class DataSource {
            private String url;
            private String driverClassName;
            private String username;
            private String password;
            //getters & setters, etc.
        }