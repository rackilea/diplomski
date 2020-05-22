@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration("Main applicationContext")
@ComponentScan(
    basePackages = {"com.where.ever"},
    excludeFilters = {@ComponentScan.Filter(Aspect.class)})
public class ApplicationConfiguration {
    @Bean(autowire = Autowire.BY_TYPE)
    public SomeAspect someAspect() {
        return Aspects.aspectOf(SomeAspect.class);
    }
    ...
    ...
}