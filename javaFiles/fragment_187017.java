@SpringBootApplication
@ComponentScan("com.cgi.poc")
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}