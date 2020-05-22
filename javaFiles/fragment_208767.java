@ApplicationScoped
public class MyBeanProducer {

    @Produces
    @FooQualifier
    public MyBean fooProducer() {
        return new MyBean(42);
    }

    @Produces
    @HooQualifier
    public MyBean hooProducer() {
        return new MyBean(666);
    }
}