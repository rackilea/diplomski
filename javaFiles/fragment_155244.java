import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Component
public class Config {

    @Bean
    public CalculatorService getCalculatorService(){
        CalculatorService calcService = new CalculatorServiceImpl();
        return calcService;
    }
}