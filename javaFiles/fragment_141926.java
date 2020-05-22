public interface ClientServiceFacade {
    ServiceA getServiceA();

    ServiceB getServiceB();

    void shutdown();
}

public class ClientServiceFacadeFactory {
    public static ClientServiceFacade create() {
        return new ClientServiceFacadeImpl();
    }
}

public class ClientServiceFacadeImpl implements ClientServiceFacade {
    private static final CONTEXT_LOCATION = "classpath:spring/context.xml";

    private ClassPathXmlApplicationContext context;

    public ClientServiceFacadeImpl() {
        context = new ClassPathXmlApplicationContext(CONTEXT_LOCATION);
    }

    @Override
    public ServiceA getServiceA() {
        return context.getBean(ServiceA.class);
    }

    @Override
    public ServiceB getServiceB() {
        return context.getBean(ServiceB.class);
    }

    @Override
    public void shutdown() {
        context.close();
    }
}