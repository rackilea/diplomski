package foo.bar;

import java.util.Hashtable;
import java.util.Map;

import org.apache.qpid.client.AMQDestination;
import org.apache.qpid.jndi.PropertiesFileInitialContextFactory;
import org.apache.qpid.jndi.ReadOnlyContext;

public class CustomPropertiesFileInitialContextFactory extends PropertiesFileInitialContextFactory {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected ReadOnlyContext createContext(Map data, Hashtable environment) {
        makeDestinationsReadOnly(data);
        return super.createContext(data, environment);
    }
    protected void makeDestinationsReadOnly(Map<String, AMQDestination> dests) {
        for(AMQDestination dest : dests.values()) {
            dest.setBrowseOnly(true);
        }
    }
}