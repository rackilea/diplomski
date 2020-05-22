import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider

@SpringBootApplication
public class Application {  
    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(Application .class, args);
    }

    @Bean
    public Server rsServer() {
        List<? extends Object> providers = new ArrayList<>();
        providers.add(getJsonProvider());
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setProviders(providers);
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.asList(new MyService())); 

        return endpoint.create();
    }

    @Bean
    public JacksonJsonProvider getJsonProvider() {
        new JacksonJsonProvider();
    }
}