@Lazy
@Configuration
@ComponentScan(...) // will be lazily initialized with config
public class LazyConfiguration {

    @Bean
    public SomeBean beanName() { // will be lazily initialized with config
        return new SomeBean();
    } 

    @Bean
    public OtherBean beanName() { // will be lazily initialized with config
        return new OtherBean();
    }     
}