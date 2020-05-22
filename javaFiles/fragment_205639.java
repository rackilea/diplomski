package somepackage.client;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.message.MessageBodyWorkers;
import org.glassfish.jersey.message.internal.MessageBodyFactory;

public class Binder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(MessageBodyFactory.class).to(MessageBodyWorkers.class);
    }

}