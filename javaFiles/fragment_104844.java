@EnableMongoRepositories
@SpringBootApplication(exclude = EmbeddedMongoAutoConfiguration.class)
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}