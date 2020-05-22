@Configuration
public class MyConfiguration
{
    @Bean @Scope(BeanDefinition.SCOPE_SINGLETON)
    public MyStuff myStuff() 
    {
        return new MyStuff();
    }
}