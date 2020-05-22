import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(name = "customPropertySource", value = "classpath:application.properties")
public class MyAppConfiguration {

}