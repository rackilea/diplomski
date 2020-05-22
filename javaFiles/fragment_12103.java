@ConfigurationProperties(prefix = "my.namespace.serviceA.impl1")
@Component
public ConcreteA implements ServiceA {
    private String prop1;
    private String prop2;
}