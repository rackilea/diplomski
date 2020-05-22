@Bean
public class ServiceCaller {
    private final SomeService serviceA;
    private final SomeService serviceB;

    @Autowired
    public ServiceCaller(@Qualifier("serviceA") SomeService serviceA,
                         @Qualifier("serviceB") SomeService serviceB) { ... }

    ...
}