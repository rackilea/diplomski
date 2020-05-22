import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc //THIS
@ComponentScan(basePackages = "guru.services") //THIS
public class AppConfig {

}