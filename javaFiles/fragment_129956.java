@Configuration
public class ApplicationConfig
{
    ...

    @Bean
    public NotExistsPredicate getNotExistsPredicate()
    {
        return new NotExistsPredicate();
    }

    @Bean
    public TestService getTestService() {
        return new TestService();
    }
}