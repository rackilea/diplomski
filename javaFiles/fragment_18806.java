@Singleton
@Startup
public class ServiceA {
    @PostConstruct
    public void init() { ... }
}

@Singleton
@Startup
@DependsOn("ServiceA")
public class ServiceB {
    @EJB
    ServiceA a;

    @PostConstruct
    public void init() { ... } // will be called after a is initialized
}