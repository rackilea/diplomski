public class MyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        // request scope binding
        bind(MyInjectablePerRequest.class)
                .to(MyInjectablePerRequest.class)
                .in(RequestScope.class);
        // singleton binding
        bind(MyInjectableSingleton.class).in(Singleton.class);
        // singleton instance binding
        bind(new MyInjectableSingleton()).to(MyInjectableSingleton.class);
    }
}