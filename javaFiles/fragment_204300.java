public class Binder extends AbstractBinder {
    @Override
    public void configurer() {
        bind(TransportImpl.class).to(Transport.class);
    }
}