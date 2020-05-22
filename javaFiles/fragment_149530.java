@Configuration
@EnableAspectJAutoProxy
public class MyConfig{

    @SessionScoped
    @Bean
    public MyClass myBean(){
        // return your bean
    }
}