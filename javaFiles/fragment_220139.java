import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public BeanOne getBeanOne() {
        return new BeanOne();
    }

    @Bean
    public BeanTwo getBeanTwo() {
        return new BeanTwo();
    }
}