@Configuration
@ComponentScan(basePackages = "com.api.core.service")
public class TestContext implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestContext.class, args);
    }
}