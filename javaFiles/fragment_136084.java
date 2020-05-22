@Configuration
public class AppConfig {

    @Value("#{${procmultiplier} == 0 ? 1 : ${procmultiplier}}")
    public Integer procMultiplier;
}