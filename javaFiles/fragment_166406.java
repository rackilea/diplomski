@Configuration
public class MyConfiguration {

    @Bean
    public MyClassInterface getMyClass() {
        return new MyClassImplementation();
    }

}