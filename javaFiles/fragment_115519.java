@Configuration
public class DemoConfiguration {
    @Autowired IFooBean fooBean;
    @Autowired IBarBean barBean;

    @Bean()
    @Scope("prototype")
    Example newExample(String name) {
        return new Example(fooBean, barBean, name);
    }
}