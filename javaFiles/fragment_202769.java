import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(AppConfiguration.class)
public class AppMain {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppMain.class);
        app.run(args);
    }
}