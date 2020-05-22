public class Binder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(Service.class).to(Service.class);
    }
}