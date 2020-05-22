static class Service {
    @Inject Dao daoA;

    public void doSomething() {
        daoA.doA();
    }
}

static class Dao {
    @Inject DataSource dataSource;

    public void doA() {
        dataSource.execute();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@BindingAnnotation
public @interface Connection {}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@BindingAnnotation
public @interface X {}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@BindingAnnotation
public @interface Y {}

static class DataSource {
    @Connection @Inject String connection;

    public void execute() {
        System.out.println("execute on: " + connection);
    }
}

static class XServiceModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(Service.class).annotatedWith(X.class).to(Service.class);
        expose(Service.class).annotatedWith(X.class);

        bindConstant().annotatedWith(Connection.class).to("http://server1");
    }
}

static class YServiceModule extends PrivateModule {
    @Override
    protected void configure() {
        bind(Service.class).annotatedWith(Y.class).to(Service.class);
        expose(Service.class).annotatedWith(Y.class);

        bindConstant().annotatedWith(Connection.class).to("http://server2");
    }
}

public static void main(String[] args) {
    Injector injector = Guice.createInjector(new XServiceModule(), new YServiceModule()); 

    Service serviceX = injector.getInstance(Key.get(Service.class, X.class));  
    serviceX.doSomething(); 

    Service serviceY = injector.getInstance(Key.get(Service.class, Y.class));
    serviceY.doSomething(); 
}