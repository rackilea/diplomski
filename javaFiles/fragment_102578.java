@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args); 
    }

    @Bean
    public MyCommandLineRunner schedulerRunner(DataSource ds) {
        return new MyCommandLineRunner(ds);
    }
}