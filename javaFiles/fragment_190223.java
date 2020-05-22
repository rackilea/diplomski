@Configuration
public class ApplicationConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FarTabController farTabController() {
        return new FarTabController() ;
    }

    // ...
}