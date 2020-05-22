@ConfigurationProperties(prefix = "default-values")
public class DefaultConfig {

    private Map<String, String> countries = new HashMap<>();
    private WHO whoHdr;

    @PostConstruct
    void init() {

        countries.put("966 - Saudi Arabia", "966");
        countries.put("965 - Kuwait", "965");        

    }  

    //setter/getter for WHO property 

}

@Configuration
@EnableConfigurationProperties(DefaultConfig.class)
class SomeConfiguration {

}