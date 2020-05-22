import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("controller") //controller is the name of the folder of my controllers
public class ApiDispatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDispatcherApplication.class, args);
    }
}