@ImportResource({"classpath*:public-api-client-spring-context.xml"}) //Proper way to import xml in Spring Boot
@SpringBootApplication
public class TraderApplication implements CommandLineRunner {

    ...code you had before goes here 

    @Autowired
    TraderApplication app;

    @Override
    public void run(String... args) throws Exception {
        .. your parsing logic here

        app.run(identifier, password, apiKey); //Now uses the autowired instance

    }
}