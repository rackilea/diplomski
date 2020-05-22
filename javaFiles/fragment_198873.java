import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

public class AppBinder extends AbstractBinder {

    @Override
    public void configure() {
        bindAsContract(MyService.class).in(RequestScoped.class);
        // note, if `MyService` is an interface, and you have 
        // an implementation, you should use the syntax
        //
        // bind(MyServiceImpl.class).to(MyService.class).in(...);
        //
        // Then you inject `MyService`. Whatever the `to(..)` is, 
        // that is what you can inject
    }
}