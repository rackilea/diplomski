@SpringBootApplication
public class TestingApplication {

    @Autowired
    RestServer server;

    public static void main(String[] args) {
        SpringApplication.run(TestingApplication.class, args);

    }

    @Bean
    public String value(@Autowired RestServer server){
        return "";
    }
}