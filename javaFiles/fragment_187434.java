@Autowired
private ServiceA serviceA;

@Bean
public ServiceB getServiceB() {
    return new ServiceB(serviceA);
}