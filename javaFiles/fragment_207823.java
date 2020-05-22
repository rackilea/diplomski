public class Application {

public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();

    }
}