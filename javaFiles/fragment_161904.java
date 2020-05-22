@Configuration
@PropertySource("classpath:application.properties")
public class RESTConfiguration
{
        @Bean
        public RESTServerFactory restServer()
        {
            return new RESTServerFactory()
        }
}

public class RESTServer {
        public String username;
        public String password;
        public String host;
        private RESTServer(String username, String password, String host)
        {
             this.username = username;
             this.password = password;
             this.host = host;
        }
}

public class RESTServerFactory {
        @Autowired Environment env;

        public RESTServer getRESTServer(String endpointName)
        {
            return new RESTServer(env.getProperty(ednpointName + ".username"),
                env.getProperty(ednpointName + ".password"),
                env.getProperty(ednpointName+".host"));
        }
}