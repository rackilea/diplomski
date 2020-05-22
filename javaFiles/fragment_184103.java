@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public MyBean bean() {
        return new MyBean();
    }

}