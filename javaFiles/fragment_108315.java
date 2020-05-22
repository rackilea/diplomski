import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"Name_controller_path"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}