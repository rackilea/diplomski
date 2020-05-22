@Configuration
@ComponentScan(basePackages = {"my.package.service"})
public class MockConfig {
    @Bean
    public BaseRepositoryImpl baseRepositoryImpl() {
        return mock(BaseRepositoryImpl.class);
    }
}