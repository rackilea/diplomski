@ConfigurationProperties(prefix = "my.namespace")
@Configuration
public SomeConfig {
    private String serviceA;

    public void setServiceA(String s) {
        serviceA = s;
    }

    @Bean
    public ServiceA serviceA() {
        if (serviceA.equals("ConcreteA1")) {
            return new ConcreteA1();
        } else {
            return new ConcreteA2();
        }
    }
}