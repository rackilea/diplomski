@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "db");
        SpringApplication.run(MyApplication.class, args);
    }
}