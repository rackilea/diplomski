@Configuration
public class MyConfiguration {
    @Bean
    public Demo demo() {
        return new Demo(50, "Hello"); // or initialize using setters
    }
}