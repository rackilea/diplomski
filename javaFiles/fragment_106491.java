public interface MyService {
    // ...
}

public class MyServiceImpl implements MyService {
    @Inject
    private MyCommand myCommand;
}

public interface MyCommand {
    // ...
}

public class MyCommandImpl implements MyCommand {
    @Inject
    private MyDAO myDAO;
}

public interface MyDAO {
    // ...
}

public class MyDAOImpl implements MyDAO {
    // ...
}

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MyService.class).to(MyServiceImpl.class);
        bind(MyCommand.class).to(MyCommandImpl.class);
        bind(MyDAO.class).to(MyDAOImpl.class);
    }
}

public class MyDriver {
    @Inject
    private MyService myService;

    public static void main(String[] args) {
        MyModule module = new MyModule();
        Injector injector = Guice.createInjector(module);
        MyDriver myDriver = injector.getInstance(MyDriver.class);

        // Should have been injected with a MyServiceImpl,
        // Which should have been injected with a MyCommandImpl,
        // Which should have been injected with a MyDAOImpl.
        myDriver.getMyService().doSomething();
    }
}