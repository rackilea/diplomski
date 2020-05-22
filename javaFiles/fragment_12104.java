@ConfigurationProperties(prefix = "my.namespace.serviceA.impl1")
public ConcreteA implements ServiceA {
    private String prop1;
    public void setProp1(String s) {
        prop1 = s;
    }
}